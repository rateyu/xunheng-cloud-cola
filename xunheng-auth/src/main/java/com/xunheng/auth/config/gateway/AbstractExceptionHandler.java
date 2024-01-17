package com.xunheng.auth.config.gateway;

import com.xunheng.base.utils.ResultUtil;
import com.xunheng.base.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.web.server.ResponseStatusException;

/**
 * @program: xunheng-cloud-cola
 * @description: 网关处的统一异常处理抽象
 * @author: hhqkkr
 * @date: 2023/6/29 12:51
 */
@Slf4j
public abstract class AbstractExceptionHandler {

    protected ResultVO<String> buildResult(Throwable e) {
        //不同异常返回不同提示与状态码
        if (e instanceof NotFoundException) {//服务下线异常
            String reason = ((NotFoundException) e).getReason();
            String s = reason.split(" ")[reason.split(" ").length - 1];
            return new ResultUtil<String>().setErrorMsg(500, s+" 服务已下线");
        } else if (e instanceof ResponseStatusException) {
            ResponseStatusException ee = (ResponseStatusException) e;
            return new ResultUtil<String>().setErrorMsg(500, ee.getMessage());
        }
        e.printStackTrace();
        return new ResultUtil<String>().setErrorMsg(500,"系统开小差了，请稍后再试【gateway inner exception】");
    }

}
