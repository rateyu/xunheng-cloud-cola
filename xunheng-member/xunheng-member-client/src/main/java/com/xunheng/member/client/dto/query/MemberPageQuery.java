package com.xunheng.member.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class MemberPageQuery extends PageDto {

   @ApiModelProperty(value = "id")
   private String id;

}
