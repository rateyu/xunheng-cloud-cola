package com.xunheng.generator.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "api代码")
    private String codeApi;

    @Schema(description = "save代码")
    private String codeSave;

    @Schema(description = "index代码")
    private String codeIndex;

}
