package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_tenant")
@ApiModel(value = "租户")
@Table
public class Tenant extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "租户名称")
    private String name;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "经营地址")
    private String address;

    @ApiModelProperty(value = "联系人姓名")
    private String contactor;

    @ApiModelProperty(value = "联系电话")
    private String contact;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    @ColumnType(MySqlTypeConstant.DATE)
    @ApiModelProperty(value = "授权到期日")
    private Date endDate;
}