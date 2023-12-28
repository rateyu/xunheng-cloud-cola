package com.xunheng.system.domain.tenant.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class TenantEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "编号")
    private String code;

    @Schema(description = "租户名称")
    private String name;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "经营地址")
    private String address;

    @Schema(description = "联系人姓名")
    private String contactor;

    @Schema(description = "联系电话")
    private String contact;

    @Schema(description = "授权到期日")
    private Date endDate;
}
