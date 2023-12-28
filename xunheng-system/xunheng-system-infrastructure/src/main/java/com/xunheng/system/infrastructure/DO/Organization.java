package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_organization")
@Schema(description = "组织架构")
@Table
public class Organization extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "部门名称")
    private String title;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "类型")
    private String type ;

    @Schema(description = "租户id")
    private String tenantId;

    @Schema(description = "分公司id")
    private String subCompanyId;

}