package com.xunheng.wechat.domain.account.model;

public enum AccountType {
    WX_FWH(1),WX_DYH(2),WX_XCX(3),WX_YDYY(4);

    public int val;

    AccountType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
