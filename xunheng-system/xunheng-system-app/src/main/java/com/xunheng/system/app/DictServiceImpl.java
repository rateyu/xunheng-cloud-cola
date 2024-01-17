package com.xunheng.system.app;

import com.xunheng.system.client.api.DictService;
import com.xunheng.system.client.dto.DictSaveCmd;
import com.xunheng.system.client.dto.VO.DictVO;
import com.xunheng.system.app.executor.DictRemoveCmdExe;
import com.xunheng.system.app.executor.DictSaveCmdExe;
import com.xunheng.system.app.executor.query.DictListQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典信息service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class DictServiceImpl implements DictService {

    @Resource
    private DictListQueryExe dictListQueryExe;

    @Resource
    DictSaveCmdExe dictSaveCmdExe;

    @Resource
    DictRemoveCmdExe dictRemoveCmdExe;

    @Override
    public List<DictVO> getAll() {
        return dictListQueryExe.execute();
    }

    @Override
    public DictVO saveOrUpdate(DictSaveCmd cmd) {
        return dictSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        dictRemoveCmdExe.execute(id);
    }
}