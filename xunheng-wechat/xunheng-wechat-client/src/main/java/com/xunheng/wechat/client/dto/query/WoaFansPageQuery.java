package com.xunheng.wechat.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class WoaFansPageQuery extends PageDto {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "appId")
   private String appId;

   @ApiModelProperty(value = "用户标签")
   private String tagId;

   @ApiModelProperty(value = "昵称")
   private String nickName;

   @ApiModelProperty(value = "城市")
   private String city;

   @ApiModelProperty(value = "关注场景值")
   private String subscribeScene;

}
