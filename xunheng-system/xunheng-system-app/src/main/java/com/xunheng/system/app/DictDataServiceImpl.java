package com.xunheng.system.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.app.executor.DictDataRemoveCmdExe;
import com.xunheng.system.app.executor.DictDataSaveCmdExe;
import com.xunheng.system.app.executor.DictDataUpdateStatusCmdExe;
import com.xunheng.system.client.api.DictDataService;
import com.xunheng.system.client.dto.query.DictDataPageQuery;
import com.xunheng.system.client.dto.DictDataSaveCmd;
import com.xunheng.system.client.dto.VO.DictDataVO;
import com.xunheng.system.app.executor.query.DictDataPageQueryExe;
import com.xunheng.system.app.executor.query.DictDataQueryByDictTypeExe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@Transactional
public class DictDataServiceImpl implements DictDataService {

    @Resource
    private DictDataPageQueryExe dictDataPageQueryExe;

    @Resource
    private DictDataQueryByDictTypeExe dictDataQueryByDictTypeExe;

    @Resource
    private DictDataUpdateStatusCmdExe dictDataUpdateStatusCmdExe;

    @Resource
    private DictDataSaveCmdExe dictDataSaveCmdExe;

    @Resource
    private DictDataRemoveCmdExe dictDataRemoveCmdExe;

    @Override
    public IPage<DictDataVO> pageList(DictDataPageQuery query) {
        return dictDataPageQueryExe.execute(query);
    }

    @Override
    public List<DictDataVO> getByDictType(String type) {
        return dictDataQueryByDictTypeExe.execute(type);
    }

    @Override
    public DictDataVO saveOrUpdate(DictDataSaveCmd cmd) {
        return dictDataSaveCmdExe.execute(cmd);
    }

    @Override
    public void updateDictStatus(String id, Integer status) {
        dictDataUpdateStatusCmdExe.execute(id,status);
    }

    @Override
    public void remove(String id) {
        dictDataRemoveCmdExe.execute(id);
    }
}