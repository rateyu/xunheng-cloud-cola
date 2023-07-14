package com.xunheng.file.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.file.app.executor.UploadSettingRemoveCmdExe;
import com.xunheng.file.app.executor.UploadSettingSaveCmdExe;
import com.xunheng.file.app.executor.query.UploadSettingPageQueryExe;
import com.xunheng.file.client.api.UploadSettingService;
import com.xunheng.file.client.dto.UploadSettingSaveCmd;
import com.xunheng.file.client.dto.VO.UploadSettingVO;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置service实现类
 * @author: hhqkkr
 * @date: 2023/7/10 13:11
 */
@Service
@GlobalTransactional
public class UploadSettingServiceImpl implements UploadSettingService {

    @Resource
    UploadSettingPageQueryExe uploadSettingPageQueryExe;

    @Resource
    UploadSettingSaveCmdExe uploadSettingSaveCmdExe;

    @Resource
    UploadSettingRemoveCmdExe uploadSettingRemoveCmdExe;

    @Override
    public IPage<UploadSettingVO> pageList(UploadSettingPageQuery query) {
        return uploadSettingPageQueryExe.execute(query);
    }

    @Override
    public UploadSettingVO saveOrUpdate(UploadSettingSaveCmd cmd) {
        return uploadSettingSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        uploadSettingRemoveCmdExe.execute(id);
    }
}
