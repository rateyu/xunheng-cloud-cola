package com.xunheng.log.app.executor.query;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.xunheng.base.utils.DateUtil;
import com.xunheng.log.app.assembler.LogAssembler;
import com.xunheng.log.client.dto.VO.LogVO;
import com.xunheng.log.client.dto.query.LogPageQuery;
import com.xunheng.log.domain.log.LogEntity;
import com.xunheng.log.domain.log.LogGateway;
import com.xunheng.log.infrastructure.DO.EsLogDO;
import com.xunheng.log.infrastructure.converter.LogConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

import java.io.IOException;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志分页查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 17:45
 */
@Component
@Slf4j
public class LogPageQueryExe {

    @Resource
    private LogGateway logGateway;

    @Resource
    private ElasticsearchClient client;

    public Page<LogVO> execute(LogPageQuery query){
        try {
            /*组装搜索条件*/
            BoolQuery.Builder boolQuery =  buildQuerys(query);
            /*组装排序条件*/
            SortOptions.Builder sort = new SortOptions.Builder();
            sort.field(builder -> builder.field("operTime").order(SortOrder.Desc));
            /*构建查询*/
            SearchResponse<EsLogDO> resp = client.search(builder ->
                            builder.index("xhcc_log")
                                    .query(boolQuery.build()._toQuery())
                                    .from(query.getPage() - 1 )
                                    .size(query.getPageSize()).sort(sort.build()),EsLogDO.class);
            List<LogEntity> collect = resp.hits().hits().stream().map(Hit::source).map(LogConverter::toEntity).toList();
            return new PageImpl<>(collect.stream().map(LogAssembler::toVo).toList(), createPage(query),resp.hits().total().value());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BoolQuery.Builder buildQuerys(LogPageQuery query) {
        BoolQuery.Builder boolBuilder = new BoolQuery.Builder();
        //检索条件
        if (!Strings.isEmpty(query.getBusinessType())){//类型查询
            MultiMatchQuery multiMatchQuery = MultiMatchQuery.of(builder -> builder.fields("businessType").query(query.getKeyword()));
            boolBuilder.must(multiMatchQuery._toQuery());
        }else if(!Strings.isEmpty(query.getKeyword())){//关键词查询
            MultiMatchQuery multiMatchQuery = MultiMatchQuery.of(builder -> builder.fields("module","title","method","operName","departmentTitle","tenantTitle","operUrl","operIp","operParam","resultStr","errorMsg").query(query.getKeyword()));
            boolBuilder.must(multiMatchQuery._toQuery());
        }else if(!Strings.isEmpty(query.getStartDate())){//日期区间查询
            Date dateStart = DateUtil.dateFormat(DateUtil.DATE_TIME_FORMAT2, query.getStartDate());
            Date dateEnd = DateUtil.dateFormat(DateUtil.DATE_TIME_FORMAT2, query.getEndDate());
            RangeQuery rangeStart = RangeQuery.of(builder -> builder.field("operTimeMillis").gte(JsonData.of(dateStart)));
            RangeQuery rangeEnd = RangeQuery.of(builder -> builder.field("operTimeMillis").lte(JsonData.of(dateEnd)));
            boolBuilder.must(rangeStart._toQuery());
            boolBuilder.must(rangeEnd._toQuery());
        }
        return boolBuilder;
    }

    /**
     * 初始化分页信息
     */
    public static Pageable createPage(LogPageQuery query){
        Pageable pageable=null;
        int pageNumber=query.getPage();
        int pageSize=query.getPageSize();
        if(pageNumber<1)pageNumber=1;
        if(pageSize<1) pageSize=10;
        pageable = PageRequest.of(pageNumber-1, pageSize);
        return pageable;
    }
}
