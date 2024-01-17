package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.annotation.Table;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_tenant")
@Schema(description = "租户")
@Table
public class Tenant extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "编号")
    private String code;

    @Schema(description = "租户名称")
    private String name;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "经营地址")
    private String address;

    @Schema(description = "联系人姓名")
    private String contactor;

    @Schema(description = "联系电话")
    private String contact;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    @ColumnType(MysqlTypeConstant.DATE)
    @Schema(description = "授权到期日")
    private Date endDate;
}