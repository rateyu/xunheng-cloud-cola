package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.MatrixColumnService;
import com.xunheng.system.client.dto.MatrixColumnSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("矩阵列")
@RestController
@RequestMapping("/matrixColumn")
public class MatrixColumnController {

    @Resource
    MatrixColumnService matrixColumnService;

    @PermissionCode("none")
    @RequestMapping(value = "/getByMatrix/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "矩阵列配置获取")
    public MatrixVO getByMatrix(@PathVariable String id){
        return matrixColumnService.getColumnByMatrix(id);
    }

    @PermissionCode("none")
    @Log(module = "矩阵列",title = "矩阵列保存", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "矩阵列新增")
    public MatrixVO save(@RequestBody MatrixColumnSaveCmd cmd){
        return matrixColumnService.saveMatrixColumn(cmd);
    }

}
