package com.xunheng.system.domain.sasession.gateway;

/**
 * @program: xunheng-cloud-cola
 * @description:  SaSession网关
 * @author: hhqkkr
 * @date: 2023/6/30 00:16
 */
public interface SaSessionGateway {

    /**
     * 删除过期的session
     */
    void cleanExpiredTokenSession();

}
