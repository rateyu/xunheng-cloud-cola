package com.xunheng.system.client.dto.VO;

import com.xunheng.base.vo.system.UserVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class SaSessionVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "token")
    private String token;

    @Schema(description = "sessionId")
    private String sessionId;

    @Schema(description = "loginId")
    private String loginId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "租户名称")
    private String tenantTitle;

    @Schema(description = "登录时间")
    private String loginTime;

    @Schema(description = "ip")
    private String ip;

    @Schema(description = "登录设备")
    private String device;

    @Schema(description = "用户信息")
    private UserVO userInfo;

}
