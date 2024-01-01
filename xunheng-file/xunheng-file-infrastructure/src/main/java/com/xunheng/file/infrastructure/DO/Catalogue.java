package com.xunheng.file.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@TableName("f_catalogue")
@Table
@Schema(description = "文件目录")
public class Catalogue extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "目录名称")
    private String title;

    @Schema(description = "目录路径")
    private String dir;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

}
