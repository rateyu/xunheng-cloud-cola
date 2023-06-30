package com.xunheng.datasource.config.handler;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xunheng.base.utils.SnowFlakeUtil;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.datasource.client.api.FeignSystemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: mybatisplus审计插件 自动填充对应字段
 * @author: hhqkkr
 * @create: 2021-12-20 14:38
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private FeignSystemService feignSystemService;

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            log.info("start insert fill ....");
            boolean login = StpUtil.isLogin();
            if(login){
                UserVO user = feignSystemService.getUserDetailByUserId(StpUtil.getLoginId(""));
                if(user != null){
                    this.strictInsertFill(metaObject, "createBy",String.class,  user.getId()); //创建者
                    this.strictInsertFill(metaObject, "departmentId",String.class, StringUtils.isEmpty(user.getOrganizationId())?StringUtils.isEmpty(user.getSubCompanyId())?user.getTenantId():user.getSubCompanyId():user.getOrganizationId()); //数据绑定部门id
                    this.strictInsertFill(metaObject, "subCompanyId",String.class, StringUtils.isEmpty(user.getSubCompanyId())?user.getTenantId():user.getSubCompanyId()); //数据绑定部门id
                    this.strictInsertFill(metaObject, "tenantId",String.class, user.getTenantId()); //数据绑定租户id
                }
            }
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); //创建时间
            this.strictInsertFill(metaObject, "id",String.class, SnowFlakeUtil.nextId().toString()); //id
        }catch (SaTokenException e){
            log.info("无request");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            log.info("start update fill ....");
            boolean login = StpUtil.isLogin();
            if(login) {
                UserVO user = feignSystemService.getUserDetailByUserId(StpUtil.getLoginId(""));
                if(user != null)this.strictUpdateFill(metaObject, "updateBy",String.class, user.getId()); //创建者
            }
            this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date()); //创建时间
        }catch (SaTokenException e){
            log.info("无request");
        }
    }

}