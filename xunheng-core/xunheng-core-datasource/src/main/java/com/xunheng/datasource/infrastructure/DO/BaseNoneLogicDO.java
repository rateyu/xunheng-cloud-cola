package com.xunheng.datasource.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 不包含逻辑删除的基础DO
 * @author: hhqkkr
 * @date: 2023/6/29 17:11
 */
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public abstract class BaseNoneLogicDO implements Serializable{

    private static final long serialVersionUID = 1L;

    @TableField(value = "id",fill = FieldFill.INSERT)
    @Schema(description = "唯一标识")
    private String id;

    @TableField(value = "create_by",fill = FieldFill.INSERT)
    @Schema(description = "创建者")
    private String createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ColumnType(MysqlTypeConstant.DATETIME)
    @Schema(description = "创建时间")
    private Date createTime;

    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    @Schema(description = "更新者")
    private String updateBy;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    @Schema(description = "更新时间")
    @ColumnType(MysqlTypeConstant.DATETIME)
    private Date updateTime;

    @TableField(value = "tenant_id",fill = FieldFill.INSERT)
    @Schema(description = "数据租户id")
    private String tenantId;

    @TableField(value = "sub_company_id",fill = FieldFill.INSERT)
    @Schema(description = "分公司id")
    private String subCompanyId;

    @TableField(value = "department_id",fill = FieldFill.INSERT)
    @Schema(description = "数据部门id")
    private String departmentId;
}
