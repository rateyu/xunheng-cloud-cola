package com.xunheng.auth.app.assembler;

import com.xunheng.auth.client.dto.VO.CaptchaVO;
import com.xunheng.auth.domain.login.model.CaptchaEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 验证码DTO转换
 * @author: hhqkkr
 * @date: 2023/6/29 12:43
 */
public class CaptchaAssembler {

    public static CaptchaVO toVo(CaptchaEntity entity) {
        CaptchaVO vo = new CaptchaVO();
        vo.setCaptchaId(entity.getCaptchaId());
        vo.setBase64Src(entity.getCaptchaImg().getSrc());
        return vo;
    }
}
