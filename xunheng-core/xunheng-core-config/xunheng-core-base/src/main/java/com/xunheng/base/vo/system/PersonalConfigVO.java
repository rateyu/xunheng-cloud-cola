package com.xunheng.base.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 个人个性化设置vo
 * @author: hhqkkr
 * @create: 2021-12-18 18:49
 */
@Data
public class PersonalConfigVO {

    @Schema(description = "设置名称")
    private String configKey;

    @Schema(description = "值")
    private String configValue;

}
