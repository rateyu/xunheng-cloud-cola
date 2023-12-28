package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.FeedbackService;
import com.xunheng.system.client.dto.FeedbackSaveCmd;
import com.xunheng.system.client.dto.VO.FeedbackVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;


@Tag(name="意见反馈")
@RestResponse
@RequestMapping("/feedback")
public class FeedbackController {

    @Resource
    FeedbackService feedbackService;

    @PermissionCode("none")
    @Log(module = "意见反馈",title = "保存意见反馈", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "保存意见反馈")
    public FeedbackVO save(@RequestBody FeedbackSaveCmd cmd){
        return feedbackService.saveOrUpdate(cmd);
    }

}
