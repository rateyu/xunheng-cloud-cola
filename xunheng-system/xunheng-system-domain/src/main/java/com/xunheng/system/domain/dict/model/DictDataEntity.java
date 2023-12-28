package com.xunheng.system.domain.dict.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class DictDataEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "数据名称")
    private String title;

    @Schema(description = "数据值")
    private String value;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "所属字典")
    private DictEntity dictEntity;
}
