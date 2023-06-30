package com.xunheng.security.config.aop;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.utils.DpContext;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.security.client.api.FeignSystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限码数据权限切面 除了网关外所有方法都要加PermissionCode这个注解 没有则none
 * @author: hhqkkr
 * @create: 2022-01-10 17:35
 */
@Aspect
@Component
public class PermissionCodeAspect {

    @Resource
    private FeignSystemService feignSystemService;

    @Before("@annotation(code)")
    public void doBefore(JoinPoint point, PermissionCode code) throws Throwable
    {
        DpContext.clean(); //清空上一次的数据过滤条件
        if(!StpUtil.isLogin())return;
        //检查权限
        if(!code.value()[0].equals("none"))StpUtil.checkPermissionAnd(code.value());
        //获取权限码与当前客户所关联的角色
        List<RoleVO> roleList = feignSystemService.getRoleByUserAndAction(StpUtil.getLoginId()+"",code.value()[0]);
        if(roleList.size() == 0){//没有角色
            RoleVO roleVo = new RoleVO();
            if(isSuperAdmin()){//是不是超级管理员
                roleVo.setDataType(CommonConstant.DATA_TYPE_LEVEL);
                roleVo.setDataLevel(CommonConstant.DATA_LEVEL_ALL);
            }else if(code.value()[0].equals("none")){//none代表该方法不需要数据权限 只需基本的租户过滤
                roleVo.setDataType(CommonConstant.DATA_TYPE_LEVEL);
                roleVo.setDataLevel(CommonConstant.DATA_LEVEL_TENANT);
            }
            roleList.add(roleVo);
        }
        DpContext.setData(roleList);
    }

    /**
     * 当前用户是否是超级管理员
     * @return 是否
     */
    private boolean isSuperAdmin(){
        UserVO user = feignSystemService.getUserDetailByUserId(StpUtil.getLoginId(""));
        if(user == null)return false;
        return Objects.equals(user.getType(), CommonConstant.USER_TYPE_SUPER_ADMIN);
    }

}
