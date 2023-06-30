package com.xunheng.system.client.dto.VO;

import com.xunheng.base.vo.system.UserVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class SaSessionVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "sessionId")
    private String sessionId;

    @ApiModelProperty(value = "loginId")
    private String loginId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "租户名称")
    private String tenantTitle;

    @ApiModelProperty(value = "登录时间")
    private String loginTime;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "登录设备")
    private String device;

    @ApiModelProperty(value = "用户信息")
    private UserVO userInfo;

}
