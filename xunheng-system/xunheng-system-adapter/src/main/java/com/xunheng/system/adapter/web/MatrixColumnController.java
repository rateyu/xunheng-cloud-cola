package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.MatrixColumnService;
import com.xunheng.system.client.dto.MatrixColumnSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@Tag(name="矩阵列")
@RestResponse
@RequestMapping("/matrixColumn")
public class MatrixColumnController {

    @Resource
    MatrixColumnService matrixColumnService;

    @PermissionCode("none")
    @RequestMapping(value = "/getByMatrix/{id}",method = RequestMethod.GET)
    @Operation(summary = "矩阵列配置获取")
    public MatrixVO getByMatrix(@PathVariable String id){
        return matrixColumnService.getColumnByMatrix(id);
    }

    @PermissionCode("none")
    @Log(module = "矩阵列",title = "矩阵列保存", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "矩阵列新增")
    public MatrixVO save(@RequestBody MatrixColumnSaveCmd cmd){
        return matrixColumnService.saveMatrixColumn(cmd);
    }

}
