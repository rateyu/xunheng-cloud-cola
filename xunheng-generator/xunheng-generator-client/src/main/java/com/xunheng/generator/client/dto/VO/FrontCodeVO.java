package com.xunheng.generator.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 前端代码VO
 * @author: hhqkkr
 * @date: 2023/7/4 13:34
 */
@Data
@AllArgsConstructor
public class FrontCodeVO {

    @ApiModelProperty(value = "api代码")
    private String codeApi;

    @ApiModelProperty(value = "save代码")
    private String codeSave;

    @ApiModelProperty(value = "index代码")
    private String codeIndex;

}
