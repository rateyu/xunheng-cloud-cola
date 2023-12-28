package com.xunheng.member.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class MemberPageQuery extends PageDto {

   @Schema(description = "id")
   private String id;

}
