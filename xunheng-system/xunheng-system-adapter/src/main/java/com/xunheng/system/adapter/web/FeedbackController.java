package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.FeedbackService;
import com.xunheng.system.client.dto.FeedbackSaveCmd;
import com.xunheng.system.client.dto.VO.FeedbackVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api("意见反馈")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Resource
    FeedbackService feedbackService;

    @PermissionCode("none")
    @Log(module = "意见反馈",title = "保存意见反馈", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "保存意见反馈")
    public FeedbackVO save(@RequestBody FeedbackSaveCmd cmd){
        return feedbackService.saveOrUpdate(cmd);
    }

}
