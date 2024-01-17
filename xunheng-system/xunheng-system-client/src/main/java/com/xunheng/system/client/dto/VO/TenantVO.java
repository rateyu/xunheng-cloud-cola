package com.xunheng.system.client.dto.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class TenantVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "编号")
    private String code;

    @Schema(description = "租户名称")
    private String name;

    @Schema(description = "联系人姓名")
    private String contactor;

    @Schema(description = "联系电话")
    private String contact;

    @Schema(description = "经营地址")
    private String address;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @Schema(description = "授权到期日")
    private Date endDate;
}
