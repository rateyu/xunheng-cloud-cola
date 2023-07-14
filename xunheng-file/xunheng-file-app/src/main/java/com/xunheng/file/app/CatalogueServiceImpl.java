package com.xunheng.file.app;

import com.xunheng.file.app.executor.CatalogueRemoveCmdExe;
import com.xunheng.file.app.executor.CatalogueSaveCmdExe;
import com.xunheng.file.app.executor.query.CatalogueListQueryExe;
import com.xunheng.file.client.api.CatalogueService;
import com.xunheng.file.client.dto.CatalogueSaveCmd;
import com.xunheng.file.client.dto.VO.CatalogueVO;
import lombok.Data;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 目录服务实现类
 * @author: hhqkkr
 * @date: 2023/7/10 12:35
 */
@Service
@GlobalTransactional
public class CatalogueServiceImpl implements CatalogueService {

    @Resource
    CatalogueSaveCmdExe catalogueSaveCmdExe;

    @Resource
    CatalogueRemoveCmdExe catalogueRemoveCmdExe;

    @Resource
    CatalogueListQueryExe catalogueListQueryExe;

    @Override
    public List<CatalogueVO> allList() {
        return catalogueListQueryExe.execute();
    }

    @Override
    public CatalogueVO saveOrUpdate(CatalogueSaveCmd cmd) {
        return catalogueSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        catalogueRemoveCmdExe.execute(id);
    }
}
