package com.xunheng.system.client.dto;

import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "个性签名")
    private String about;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "邮件")
    private String email;

}
