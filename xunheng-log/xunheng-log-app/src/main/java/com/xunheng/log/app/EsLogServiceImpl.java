package com.xunheng.log.app;

import com.xunheng.log.app.executor.LogCreateCmdExe;
import com.xunheng.log.app.executor.LogRemoveAllCmdExe;
import com.xunheng.log.app.executor.LogRemoveCmdExe;
import com.xunheng.log.app.executor.query.LogEchartsDataQueryExe;
import com.xunheng.log.app.executor.query.LogPageQueryExe;
import com.xunheng.log.client.api.SysLogService;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.log.client.dto.VO.LogVO;
import com.xunheng.log.client.dto.query.LogPageQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class EsLogServiceImpl implements SysLogService {

    @Resource
    private LogPageQueryExe logPageQueryExe;

    @Resource
    private LogEchartsDataQueryExe logEchartsDataQueryExe;

    @Resource
    private LogRemoveCmdExe logRemoveCmdExe;

    @Resource
    private LogRemoveAllCmdExe logRemoveAllCmdExe;

    @Resource
    private LogCreateCmdExe logCreateCmdExe;


    @Override
    public Page<LogVO> pageList(LogPageQuery query) {
        return logPageQueryExe.execute(query);
    }

    @Override
    public Map<String, Object> getEchartsData() {
        return logEchartsDataQueryExe.execute();
    }

    @Override
    public void remove(String id) {
        logRemoveCmdExe.execute(id);
    }

    @Override
    public void removeAll() {
        logRemoveAllCmdExe.execute();
    }

    @Override
    public LogVO save(LogCreateCmd cmd) {
        return logCreateCmdExe.execute(cmd);
    }
}
