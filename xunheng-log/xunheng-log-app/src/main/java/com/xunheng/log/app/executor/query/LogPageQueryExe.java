package com.xunheng.log.app.executor.query;

import com.xunheng.base.utils.DateUtil;
import com.xunheng.log.app.assembler.LogAssembler;
import com.xunheng.log.client.dto.VO.LogVO;
import com.xunheng.log.client.dto.query.LogPageQuery;
import com.xunheng.log.domain.log.LogEntity;
import com.xunheng.log.domain.log.LogGateway;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

    public Page<LogVO> execute(LogPageQuery query){
        /*组装搜索条件*/
        BoolQueryBuilder bqb =  buildQuerys(query);
        /*组装排序条件*/
        FieldSortBuilder fsb = SortBuilders.fieldSort("operTime").order(SortOrder.DESC);
        /*组装分页条件*/
        Pageable pageable = initPage(query);
        /*构建查询*/
        NativeSearchQuery queryCondition = new NativeSearchQueryBuilder()
                    .withQuery(bqb)
                    .withSort(fsb)
                    .withPageable(pageable)
                    .build();
        Page<LogEntity> logEntities = logGateway.pageList(queryCondition);
        List<LogVO> collect = logEntities.getContent().stream().map(LogAssembler::toVo).collect(Collectors.toList());
         return new PageImpl<>(collect, logEntities.getPageable(), logEntities.getTotalElements());
    }

    private BoolQueryBuilder buildQuerys(LogPageQuery query) {
        //检索条件
        BoolQueryBuilder bqb = QueryBuilders.boolQuery();
        if (!Strings.isEmpty(query.getBusinessType()))
            bqb.must(QueryBuilders.matchPhraseQuery("businessType", query.getBusinessType()));
        if (!Strings.isEmpty(query.getKeyword()))
            bqb.must(QueryBuilders.multiMatchQuery(query.getKeyword(), "module","title","method","operName","departmentTitle","tenantTitle","operUrl","operIp","operParam","resultStr","errorMsg"));
        if(!Strings.isEmpty(query.getStartDate()))
        // 范围查询 from:相当于闭区间; gt:相当于开区间(>) gte:相当于闭区间 (>=) lt:开区间(<) lte:闭区间 (<=)
        {
            Date dateStart = DateUtil.dateFormat(DateUtil.DATE_TIME_FORMAT2, query.getStartDate());
            Date dateEnd = DateUtil.dateFormat(DateUtil.DATE_TIME_FORMAT2, query.getEndDate());
            bqb.filter(QueryBuilders.rangeQuery("operTimeMillis").gte(dateStart.getTime()).lte(dateEnd.getTime()));
        }
        return bqb;
    }

    /**
     * 初始化分页信息
     */
    public static Pageable initPage(LogPageQuery query){
        Pageable pageable=null;
        int pageNumber=query.getPage();
        int pageSize=query.getPageSize();
        if(pageNumber<1)pageNumber=1;
        if(pageSize<1) pageSize=10;
        pageable = PageRequest.of(pageNumber-1, pageSize);
        return pageable;
    }
}
