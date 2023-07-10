package com.xunheng.file.domain.catalogue.model;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class CatalogueEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "目录名称")
    private String title;

    @ApiModelProperty(value = "目录路径")
    private String dir;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @TableField(exist=false)
    @ApiModelProperty(value = "下级目录")
    private List<CatalogueEntity> children;
}
