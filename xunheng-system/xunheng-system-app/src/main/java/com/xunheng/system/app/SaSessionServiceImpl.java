package com.xunheng.system.app;

import com.xunheng.system.client.api.SaSessionService;
import com.xunheng.system.client.dto.VO.SaSessionVO;
import com.xunheng.system.app.executor.SaSessionChangeCmdExe;
import com.xunheng.system.app.executor.SaSessionKickOutCmdExe;
import com.xunheng.system.app.executor.query.SaSessionListQueryExe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: sasession service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@Transactional
public class SaSessionServiceImpl implements SaSessionService {

    @Resource
    private SaSessionListQueryExe saSessionListQueryExe;

    @Resource
    private SaSessionKickOutCmdExe saSessionKickOutCmdExe;

    @Resource
    private SaSessionChangeCmdExe saSessionChangeCmdExe;

    @Override
    public List<SaSessionVO> getAll(String username) {
        return saSessionListQueryExe.execute(username);
    }

    @Override
    public void kickOutByToken(String token) {
        saSessionKickOutCmdExe.execute(token);
    }

    @Override
    public void changeSession(String token) {
        saSessionChangeCmdExe.execute(token);
    }
}