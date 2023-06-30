package com.xunheng.system.domain.role.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class RoleEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "角色名 以ROLE_开头")
    private String name;

    @ApiModelProperty(value = "数据权限类型 CommonConstant.DATA_TYPE_*")
    private Integer dataType = CommonConstant.DATA_TYPE_LEVEL;

    @ApiModelProperty(value = "数据权限级别 CommonConstant.DATA_LEVEL_*")
    private Integer dataLevel = CommonConstant.DATA_LEVEL_NONE;

    @ApiModelProperty(value = "自定义表达式")
    private String customExpression;

    @ApiModelProperty(value = "是否含下级 0:否 1:是")
    private Integer includeLow = -1;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "拥有数据权限范围")
    private String organizationIds;

    @ApiModelProperty(value = "拥有菜单权限")
    private List<RolePermissionEntity> permissions;

/*     @ApiModelProperty(value = "拥有数据权限范围")
    private List<RoleOrganizationEntity> organizations;

   public void setOrganizationIds(List<RoleOrganizationEntity> ros) {
        if(CollectionUtil.isEmpty(ros)){
            this.organizationIds = "";
            return;
        }
        String orgs = "";
        for (RoleOrganizationEntity organization : ros) {
            String organizationId = organization.getOrganizationId();
            orgs += "'"+organizationId+"',";
        }
        this.organizationIds = orgs.substring(0,orgs.length()-1);
    }*/
}
