package com.xunheng.base.vo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户登录校验vo
 * @author: hhqkkr
 * @date: 2023/6/29 14:22
 */
@Data
public class UserLoginVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Schema(description = "租户id")
    private String tenantId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

}
