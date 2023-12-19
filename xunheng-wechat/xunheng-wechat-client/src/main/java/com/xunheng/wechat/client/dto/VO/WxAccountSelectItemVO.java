package com.xunheng.wechat.client.dto.VO;

import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信账号选择器前端select项
 * @author: hhqkkr
 * @date: 2023/12/5 14:19
 */
@Data
public class WxAccountSelectItemVO {

    /**
     * appId
     */
    String appId;

    /**
     * 名称
     */
    String name;

    /**
     * 类型
     */
    Integer type;

}
