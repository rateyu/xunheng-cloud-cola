package com.xunheng.generator.domain.genConfig.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 前端代码实体
 * @author: hhqkkr
 * @date: 2023/7/4 13:34
 */
@Data
@AllArgsConstructor
public class FrontCodeEntity {

    @Schema(description = "api代码")
    private String codeApi;

    @Schema(description = "save代码")
    private String codeSave;

    @Schema(description = "index代码")
    private String codeIndex;

}
