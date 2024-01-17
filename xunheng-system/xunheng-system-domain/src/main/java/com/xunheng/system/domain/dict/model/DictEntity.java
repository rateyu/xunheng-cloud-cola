package com.xunheng.system.domain.dict.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.system.domain.dict.gateway.DictGateway;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.annotation.Resource;
import java.math.BigDecimal;

@Data
@Entity
public class DictEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "字典名称")
    private String title;

    @Schema(description = "字典类型")
    private String DictType;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Resource
    private DictGateway dictGateway;

    public DictEntity(String dictId,String dictTitle,String dictType){
        this.id = dictId;
        this.title = dictTitle;
        this.DictType = dictType;
    }

    public DictEntity(){
    }
}
