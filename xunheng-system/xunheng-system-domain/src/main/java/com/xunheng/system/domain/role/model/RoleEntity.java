package com.xunheng.system.domain.role.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class RoleEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "角色名 以ROLE_开头")
    private String name;

    @Schema(description = "数据权限类型 CommonConstant.DATA_TYPE_*")
    private Integer dataType = CommonConstant.DATA_TYPE_LEVEL;

    @Schema(description = "数据权限级别 CommonConstant.DATA_LEVEL_*")
    private Integer dataLevel = CommonConstant.DATA_LEVEL_NONE;

    @Schema(description = "自定义表达式")
    private String customExpression;

    @Schema(description = "是否含下级 0:否 1:是")
    private Integer includeLow = -1;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "拥有数据权限范围")
    private String organizationIds;

    @Schema(description = "拥有菜单权限")
    private List<RolePermissionEntity> permissions;

/*     @Schema(description = "拥有数据权限范围")
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
