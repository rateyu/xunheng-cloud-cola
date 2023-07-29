package com.xunheng.wechat.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class WechatAccountPageQuery extends PageDto {

   @ApiModelProperty(value = "id")
   private String id;

}
