package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.VO.SaSessionVO;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: sa会话service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:23
 */
public interface SaSessionService {

    /**
     * 获取当前在线用户
     * @param username 用户名称
     * @return 会话列表
     */
    List<SaSessionVO> getAll(String username);

    /**
     * 下线
     * @param token
     */
    void kickOutByToken(String token);

    /**
     * 切换session
     * @param token
     */
    void changeSession(String token);

}
