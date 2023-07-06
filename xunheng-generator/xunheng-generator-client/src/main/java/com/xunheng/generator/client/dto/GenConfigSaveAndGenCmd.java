package com.xunheng.generator.client.dto;

import com.xunheng.generator.client.dto.VO.GenConfigFieldVO;
import com.xunheng.generator.client.dto.VO.GenFrontConfigFieldVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GenConfigSaveAndGenCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "实体名")
    private String name;

    @ApiModelProperty(value = "领域名称")
    private String domainName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "表名前缀")
    private String tablePrefix;

    @ApiModelProperty(value = "表名简称")
    private String tableAlias;

    @ApiModelProperty(value = "服务名")
    private String serviceName;

    @ApiModelProperty(value = "表字段")
    private List<GenConfigFieldVO> fieldList;

    @ApiModelProperty(value = "前端展示字段")
    private List<GenFrontConfigFieldVO> frontFieldList;
}
