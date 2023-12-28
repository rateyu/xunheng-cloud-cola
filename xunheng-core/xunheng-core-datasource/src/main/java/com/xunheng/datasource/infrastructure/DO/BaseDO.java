package com.xunheng.datasource.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 基础DO
 * @author: hhqkkr
 * @date: 2023/6/29 17:11
 */
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public abstract class BaseDO implements Serializable{

    private static final long serialVersionUID = 1L;

    @TableField(value = "id",fill = FieldFill.INSERT)
    @Schema(description = "唯一标识")
    private String id;

    @TableField(value = "create_by",fill = FieldFill.INSERT)
    @Schema(description = "创建者")
    private String createBy;


    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ColumnType(MySqlTypeConstant.DATETIME)
    @Schema(description = "创建时间")
    private Date createTime;

    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    @Schema(description = "更新者")
    private String updateBy;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    @Schema(description = "更新时间")
    @ColumnType(MySqlTypeConstant.DATETIME)
    private Date updateTime;

    @TableLogic
    @Schema(description = "删除标志 默认0")
    private Integer delFlag = CommonConstant.STATUS_NORMAL;

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
