package com.xunheng.system.domain.dict.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.system.domain.dict.gateway.DictGateway;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Data
@Entity
public class DictEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "字典名称")
    private String title;

    @ApiModelProperty(value = "字典类型")
    private String DictType;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "排序值")
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
