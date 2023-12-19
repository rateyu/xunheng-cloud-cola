package com.xunheng.wechat.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WoaImgTextPageQuery extends PageDto {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "appId")
   private String appId;

}
