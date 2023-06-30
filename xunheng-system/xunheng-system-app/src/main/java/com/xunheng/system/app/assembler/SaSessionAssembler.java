package com.xunheng.system.app.assembler;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.xunheng.base.constant.SaSessionConstant;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.client.dto.VO.SaSessionVO;

/**
 * @program: xunheng-cloud-cola
 * @description: sasession dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:37
 */
public class SaSessionAssembler {
    public static SaSessionVO toVo(String tokenSessionId){
        SaSessionVO vo = new SaSessionVO();
        vo.setSessionId(tokenSessionId);
        /*根据sessionid找到session 配置session里的信息*/
        SaSession tokenSession = StpUtil.getSessionBySessionId(tokenSessionId);
        vo.setDevice(tokenSession.getString("device"));
        vo.setIp(tokenSession.getString("ip"));
        vo.setLoginTime(tokenSession.getString("loginTime"));
        String token = tokenSession.getString("token");
        vo.setToken(token);
        String loginId = String.valueOf(StpUtil.getLoginIdByToken(token));
        vo.setLoginId(loginId);
        /*配置用户信息*/
        SaSession userSession = StpUtil.getSessionByLoginId(loginId);
        Object v = userSession.get(SaSessionConstant.USER_INFO_KEY);
        if(v != null){
            UserVO user = JSON.toJavaObject(JSON.parseObject(v.toString()), UserVO.class);
            vo.setUsername(user.getUsername());
            vo.setTenantTitle(user.getTenantTitle());
            vo.setUserInfo(user);
        }else{
            vo.setUsername("");
            vo.setTenantTitle("");
        }
        return vo;
    }
}
