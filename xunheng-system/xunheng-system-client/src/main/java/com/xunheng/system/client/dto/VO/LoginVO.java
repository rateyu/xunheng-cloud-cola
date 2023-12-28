package com.xunheng.system.client.dto.VO;

import com.xunheng.base.vo.system.UserVO;
import lombok.Data;

@Data
public class LoginVO {

    //用户信息VO
    private UserVO user;

   //用户token
    private String token;
}
