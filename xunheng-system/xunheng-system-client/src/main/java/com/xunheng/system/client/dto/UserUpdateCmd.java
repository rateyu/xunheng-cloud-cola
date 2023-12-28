package com.xunheng.system.client.dto;

import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "个性签名")
    private String about;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "生日")
    private Date birth;

    @Schema(description = "手机")
    private String mobile;

    @Schema(description = "邮件")
    private String email;

}
