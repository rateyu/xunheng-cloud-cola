package com.xunheng.wechat.domain.msgFeed.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;

import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class WoaMsgTemplateEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "模板Id")
    private String templateId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "数据")
    private String data;

    @Schema(description = "链接地址")
    private String url;

    @Schema(description = "小程序")
    private String miniProgram;

    @Schema(description = "状态")
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
