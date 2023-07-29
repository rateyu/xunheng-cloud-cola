package com.xunheng.wechat.domain.wechatAccount.model;

public enum AccountType {
    WOA_FWH(1),WOA_DYH(2),WOA_XCX(3),WOA_YDYY(4);

    public int val;

    AccountType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
