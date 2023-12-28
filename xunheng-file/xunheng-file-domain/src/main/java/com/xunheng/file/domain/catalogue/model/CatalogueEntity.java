package com.xunheng.file.domain.catalogue.model;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class CatalogueEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "目录名称")
    private String title;

    @Schema(description = "目录路径")
    private String dir;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @TableField(exist=false)
    @Schema(description = "下级目录")
    private List<CatalogueEntity> children;
}
