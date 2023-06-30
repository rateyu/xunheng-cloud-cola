package com.xunheng.system.app.executor.query;

import com.alibaba.fastjson.JSONObject;
import com.xunheng.system.app.assembler.MatrixColumnAssembler;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.domain.matrix.gateway.MatrixColumnGateway;
import com.xunheng.system.domain.matrix.gateway.MatrixDataGateway;
import com.xunheng.system.domain.matrix.model.MatrixColumnEntity;
import com.xunheng.system.domain.matrix.model.MatrixDataEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 根据矩阵id查询矩阵数据处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:43
 */
@Component
public class MatrixDataListQueryExe {

    @Resource
    MatrixDataGateway matrixDataGateway;

    @Resource
    MatrixColumnGateway matrixColumnGateway;

    public MatrixVO execute(String matrixId) {
        MatrixVO matrixVO = new MatrixVO();
        /*根据id拿到矩阵列表*/
        List<MatrixColumnEntity> columnList = matrixColumnGateway.getListByMatrixId(matrixId);
        matrixVO.setColumnList(columnList.stream().map(MatrixColumnAssembler::toVo).collect(Collectors.toList()));
        /*根据id查询到矩阵数据*/
        List<MatrixDataEntity> matrixDataEntityList = matrixDataGateway.getListByMatrixId(matrixId);
        /*矩阵数据根据矩阵的rowId进行分组*/
        Map<String, List<MatrixDataEntity>> rows = matrixDataEntityList.stream().collect(Collectors.groupingBy(MatrixDataEntity::getRowId, LinkedHashMap::new,Collectors.toList()));
        List<JSONObject> dataList = new ArrayList<>();
        /*遍历row组装成需要的json数据*/
        rows.forEach((key, value) -> {
            JSONObject row = new JSONObject();
            row.put("rowId", key);//对象先放入rowId
            for (MatrixDataEntity rowData : value) {
                row.put(rowData.getColumnTag(), rowData.getData());
            }
            dataList.add(row);
        });
        /*组装矩阵信息*/
        matrixVO.setId(matrixId);
        matrixVO.setDataList(dataList);
        return matrixVO;
    }
}
