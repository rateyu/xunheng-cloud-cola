package com.xunheng.system.domain.user.ability.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.constant.SaSessionConstant;
import com.xunheng.system.client.dto.query.UserPageQuery;
import com.xunheng.system.domain.customConfig.gateway.CustomConfigGateway;
import com.xunheng.system.domain.user.gateway.UserRoleGateway;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户领域服务实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:24
 */
@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Resource
    private UserGateway userGateway;

    @Resource
    private CustomConfigGateway customConfigGateway;

    @Resource
    private UserRoleGateway userRoleGateway;

    @Resource
    private OrganizationGateway organizationGateway;

    @Override
    public UserEntity getUserDetailByUsername(String username) {
        UserPageQuery query = new UserPageQuery();
        query.setUsername(username);
        query.setStatus(CommonConstant.USER_STATUS_NORMAL);
        List<UserEntity> records = userGateway.pageList(query).getRecords();
        if(CollectionUtil.isEmpty(records))return null;
        UserEntity user = records.get(0);
        /*绑定角色信息*/
        user.bindRoleInfo(userRoleGateway.getByUserId(user.getId()));
        /*绑定下级信息*/
        user.setUserLowIds(user.getId()+getUserLowIds("",user.getId()));
        /*找到所有下级部门*/
        user.setDepartmentLowIds(user.getOrganizationId()+getDepartmentLowIds("",user.getOrganizationId()));
        /*自定义设置*/
        user.setPersonalConfigs(customConfigGateway.getPersonalConfigsByUserId(user.getId()));
        return user;
    }

    @Override
    public UserEntity getUserDetailById(String userId) {
        //从缓存获取 没有再进行查询
        SaSession userSession = StpUtil.getSessionByLoginId(userId,true);
        Object v = userSession.get(SaSessionConstant.USER_INFO_KEY);
        if(v != null){
            JSONObject userInfo = JSON.parseObject(v.toString());
            return JSON.toJavaObject(JSON.parseObject(userInfo.toString()), UserEntity.class);
        }
        UserEntity user = userGateway.getOneById(userId);
        if(user == null)return null;
        return this.getUserDetailByUsername(user.getUsername());
    }

    @Override
    public Boolean isSuperAdmin(String userId) {
        UserEntity user = userGateway.getOneById(userId);
        if(user == null)return false;
        return Objects.equals(user.getType(), CommonConstant.USER_TYPE_SUPER_ADMIN);
    }

    @Override
    public void reloadUserDetailCache(String userId) {
        //先删除现有的缓存
        userGateway.cleanUserDetailCache(userId);
        //如果当前用户有登录 则重新加载用户信息缓存
        SaSession userSession = StpUtil.getSessionByLoginId(userId);
        if(userSession == null)return;
        UserEntity userEntity = getUserDetailById(userId);
        if(userEntity == null)return;
        System.out.println("reget username = "+userEntity.getUsername());
        userSession.set(SaSessionConstant.USER_INFO_KEY, JSON.toJSONString(userEntity));
    }

    /**
     * 获取下级id
     */
    private String getUserLowIds(String ids,String userId){
        List<UserEntity> list = userGateway.getBySuperior(userId);
        for (UserEntity user : list) {
            ids += ","+user.getId();
        }
        for (UserEntity user : list) {
            getUserLowIds(ids,user.getId());
        }
        return ids;
    }

    /**
     * 获取下级部门
     */
    private String getDepartmentLowIds(String ids,String departmentId){
        List<OrganizationEntity> list = organizationGateway.getByParentId(departmentId);
        for (OrganizationEntity organization : list) {
            ids += ","+organization.getId();
        }
        for (OrganizationEntity organization : list) {
            getDepartmentLowIds(ids,organization.getId());
        }
        return ids;
    }

}
