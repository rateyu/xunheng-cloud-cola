package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.MatrixService;
import com.xunheng.system.client.dto.query.MatrixListQuery;
import com.xunheng.system.client.dto.MatrixSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="矩阵")
@RestResponse
@RequestMapping("/matrix")
public class MatrixController {

    @Resource
    MatrixService matrixService;

    @PermissionCode("none")
    @Log(module = "矩阵",title = "矩阵所有列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @Operation(summary = "矩阵所有列表")
    public List<MatrixVO> getAll(MatrixListQuery query){
        return matrixService.getAll(query);
    }

    @PermissionCode("none")
    @Log(module = "矩阵",title = "矩阵新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "矩阵新增")
    public MatrixVO save(@RequestBody MatrixSaveCmd cmd){
        return matrixService.saveOrUpdate(cmd);
    }

    @PermissionCode("none")
    @Log(module = "矩阵",title = "矩阵修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "矩阵修改")
    public MatrixVO edit(@RequestBody MatrixSaveCmd cmd){
        return matrixService.saveOrUpdate(cmd);
    }

    @PermissionCode("none")
    @Log(module = "矩阵",title = "矩阵批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "矩阵批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            matrixService.remove(id);
        }
        return "删除成功";
    }

}
