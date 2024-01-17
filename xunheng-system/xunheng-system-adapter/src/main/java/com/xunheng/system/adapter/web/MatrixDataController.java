package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.MatrixDataService;
import com.xunheng.system.client.dto.MatrixDataSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.client.dto.query.MatrixResultByConditionQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="矩阵数据")
@RestResponse
@RequestMapping("/matrixData")
public class MatrixDataController {

    @Resource
    MatrixDataService matrixDataService;

    @PermissionCode("none")
    @RequestMapping(value = "/getByMatrix/{id}",method = RequestMethod.GET)
    @Operation(summary = "矩阵数据获取")
    public MatrixVO getConfigDataByMatrix(@PathVariable String id){
        return matrixDataService.getConfigDataByMatrix(id);
    }

    @PermissionCode("none")
    @Log(module = "矩阵数据",title = "矩阵数据新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "矩阵数据新增")
    public MatrixVO save(@RequestBody MatrixDataSaveCmd cmd){
        return matrixDataService.saveMatrixData(cmd);
    }

    @PermissionCode("none")
    @RequestMapping(value = "/getResultByCondition",method = RequestMethod.GET)
    @Operation(summary = "查询矩阵匹配数据")
    public List<String> getResultByCondition(MatrixResultByConditionQuery query){
        return matrixDataService.getResultByCondition(query);
    }
}
