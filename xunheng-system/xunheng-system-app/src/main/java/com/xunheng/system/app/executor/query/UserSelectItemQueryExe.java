package com.xunheng.system.app.executor.query;

import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户选择器查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:06
 */
@Component
public class UserSelectItemQueryExe {

    @Resource
    private UserGateway userGateway;


    public List<SelectItemVO> execute(){
        List<UserEntity> list = userGateway.getSelectItem();
        return list.stream().map(UserAssembler::toSelectItem).collect(Collectors.toList());
    }


}
