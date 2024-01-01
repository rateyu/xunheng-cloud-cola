package com.xunheng.wechat.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class WechatUserPageQuery extends PageDto {

   @Schema(description = "id")
   private String id;

   @Schema(description = "appId")
   private String appId;

   @Schema(description = "用户标签")
   private String tagId;

   @Schema(description = "昵称")
   private String nickName;

   @Schema(description = "城市")
   private String city;

   @Schema(description = "关注场景值")
   private String subscribeScene;

}
