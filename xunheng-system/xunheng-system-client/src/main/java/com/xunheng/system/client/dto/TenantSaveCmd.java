package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class TenantSaveCmd {


    @Schema(description = "id")
    private String id;

    @Schema(description = "编号")
    private String code;

    @NotBlank(message = "租户名称不能为空")
    @Schema(description = "租户名称")
    private String name;

    @NotBlank(message = "联系人姓名不能为空")
    @Schema(description = "联系人姓名")
    private String contactor;

    @NotBlank(message = "联系电话不能为空")
    @Schema(description = "联系电话")
    private String contact;

    @Schema(description = "经营地址")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "授权到期日")
    private Date endDate;



}
