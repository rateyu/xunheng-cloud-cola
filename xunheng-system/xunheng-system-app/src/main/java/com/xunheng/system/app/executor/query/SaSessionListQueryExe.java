package com.xunheng.system.app.executor.query;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.system.app.assembler.SaSessionAssembler;
import com.xunheng.system.client.dto.VO.SaSessionVO;
import com.xunheng.system.domain.sasession.gateway.SaSessionGateway;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: sasession查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:56
 */
@Component
public class SaSessionListQueryExe {

    @Resource
    private SaSessionGateway saSessionGateway;

    public List<SaSessionVO> execute(String username) {
        /*清除过期失效的session*/
        saSessionGateway.cleanExpiredTokenSession();
        List<SaSessionVO> records = new ArrayList<>();
        /*查询出所有在线的sessionId*/
        List<String> tokenSessionIds = StpUtil.searchTokenSessionId("", -1, 65535,true);
        for (String tokenSessionId : tokenSessionIds) {
            records.add(SaSessionAssembler.toVo(tokenSessionId));
        }
        return records.stream().filter(item ->{//过滤查询
            if(!StringUtils.isEmpty(username)) {
                return item.getUsername().contains(username);
            }
            return true;
        }).collect(Collectors.toList());
    }
}
