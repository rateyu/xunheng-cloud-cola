package com.xunheng.system.domain.tenant.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class TenantEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "租户名称")
    private String name;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "经营地址")
    private String address;

    @ApiModelProperty(value = "联系人姓名")
    private String contactor;

    @ApiModelProperty(value = "联系电话")
    private String contact;

    @ApiModelProperty(value = "授权到期日")
    private Date endDate;
}
