package com.xunheng.wechat.domain.msgFeed.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;

import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class WoaMsgTemplateEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "模板Id")
    private String templateId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "数据")
    private String data;

    @ApiModelProperty(value = "链接地址")
    private String url;

    @ApiModelProperty(value = "小程序")
    private String miniProgram;

    @ApiModelProperty(value = "状态")
    private String status;


    public WoaMsgTemplateEntity() {}
    public WoaMsgTemplateEntity(WxMpTemplate mpTemplate, String appId) {
        this.appId = appId;
        this.templateId=mpTemplate.getTemplateId();
        this.title=mpTemplate.getTitle();
        this.name=mpTemplate.getTemplateId();
        this.content = mpTemplate.getContent();
        this.status="1";
    }

}
