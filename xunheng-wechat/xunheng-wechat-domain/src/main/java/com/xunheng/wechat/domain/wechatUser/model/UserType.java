package com.xunheng.wechat.domain.wechatUser.model;

public enum UserType {
    WX_GZH(2),WX_XCX(3),WX_YDYY(4);

    public int val;

    UserType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
