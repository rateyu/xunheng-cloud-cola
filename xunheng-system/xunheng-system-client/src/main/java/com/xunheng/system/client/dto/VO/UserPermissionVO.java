package com.xunheng.system.client.dto.VO;

import com.xunheng.base.vo.system.PermissionVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class UserPermissionVO {

    @Schema(description = "菜单列表")
    private List<PermissionVO> userPermissionList;

    @Schema(description = "权限码集合")
    private List<String> userPermissionCodes;

    public UserPermissionVO(List<PermissionVO> userPermissionList, List<String> userPermissionCodes){
        this.userPermissionList = userPermissionList;
        this.userPermissionCodes = userPermissionCodes;
    }
}
