package com.xunheng.auth.client.dto.VO;

import com.xunheng.base.vo.system.UserVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginVO {

    @ApiModelProperty(value = "用户信息VO")
    private UserVO user;

    @ApiModelProperty(value = "用户token")
    private String token;
}
