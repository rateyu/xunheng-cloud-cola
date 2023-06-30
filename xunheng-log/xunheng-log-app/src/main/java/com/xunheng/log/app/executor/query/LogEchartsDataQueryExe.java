package com.xunheng.log.app.executor.query;

import com.xunheng.base.utils.DateUtil;
import com.xunheng.log.domain.log.LogEntity;
import com.xunheng.log.domain.log.LogGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志echarts数据查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 17:41
 */
@Component
public class LogEchartsDataQueryExe {

    @Resource
    private LogGateway logGateway;

    public Map<String, Object> execute(){
        /*设定区间未最近一个月*/
        Date endDate = DateUtil.addDaysToDate(new Date(),1);
        Date startDate = DateUtil.addDaysToDate(new Date(), -29);
        /*日期文本集合*/
        String[] dateStrs = new String[30];
        for (int i = 29; i >= 0; i--) {
            String dateStr = DateUtil.dateFormatToStr(new Date());
            Date cdate = DateUtil.addDaysToDate(dateStr, -i);
            dateStrs[29-i] = DateUtil.dateFormatToStr(cdate);
        }
        /*查询日志*/
        List<LogEntity> logs = logGateway.findByOperTimeMillisBetween(startDate.getTime(), endDate.getTime());
        /*根据日期分组*/
        Map<String, Long> collect = logs.stream().collect(Collectors.groupingBy(r -> DateUtil.dateFormatToStr(r.getOperTime()), Collectors.counting()));
        /*计算分组数量*/
        Long[] counts = new Long[30];
        for (int i = 0; i < dateStrs.length; i++) {
            Long count = collect.get(dateStrs[i]);
            if(count == null)counts[i] = 0l;
            else counts[i] = count;

        }
        /*返回*/
        Map<String, Object> map = new HashMap<>();
        map.put("date",dateStrs);
        map.put("count",counts);
        return map;
    }
}
