package com.xunheng.system.app.executor;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xunheng.base.utils.SnowFlakeUtil;
import com.xunheng.system.client.dto.MatrixDataSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.domain.matrix.gateway.MatrixDataGateway;
import com.xunheng.system.domain.matrix.model.MatrixDataEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵数据保存处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:10
 */
@Component
public class MatrixDataSaveCmdExe {

    @Resource
    private MatrixDataGateway matrixDataGateway;


    public MatrixVO execute(MatrixDataSaveCmd cmd) {
        /*前端vxe table提交 区分新增 更新 删除 的列表*/
        JSONArray removeRecords = cmd.getRemoveRecords();
        JSONArray insertRecords = cmd.getInsertRecords();
        JSONArray updateRecords = cmd.getUpdateRecords();
        String matrixId = cmd.getId();
        //新增的列表
        for (int i = 0; i < insertRecords.size(); i++) {
            JSONObject insertObject = insertRecords.getJSONObject(i);
            String rowId = SnowFlakeUtil.nextId().toString();//生成一个rowid
            for (Map.Entry<String, Object> entry: insertObject.entrySet()) {
                String key = entry.getKey();
                if(key.equals("rowId") || key.equals("_X_ROW_KEY"))continue;//rowid不保存
                String value = insertObject.getString(key);
                MatrixDataEntity matrixData = new MatrixDataEntity();
                matrixData.setMatrixId(matrixId);
                matrixData.setRowId(rowId);
                matrixData.setColumnTag(key);
                matrixData.setData(value);
                matrixDataGateway.saveOrUpdate(matrixData);
            }
        }
        //更新的列表
        for (int i = 0; i < updateRecords.size(); i++) {
            JSONObject updateObject = updateRecords.getJSONObject(i);
            String rowId = updateObject.getString("rowId");
            for (Map.Entry<String, Object> entry: updateObject.entrySet()) {
                String key = entry.getKey();
                if(key.equals("rowId") || key.equals("_X_ROW_KEY"))continue;
                String value = updateObject.getString(key);
                MatrixDataEntity matrixData = matrixDataGateway.getMatrixData(matrixId, rowId, key);
                if(matrixData == null) {
                    matrixData = new MatrixDataEntity();
                    matrixData.setMatrixId(matrixId);
                    matrixData.setRowId(rowId);
                    matrixData.setColumnTag(key);
                }
                matrixData.setData(value);
                matrixDataGateway.saveOrUpdate(matrixData);
            }
        }
        //删除的列表
        for (int i = 0; i < removeRecords.size(); i++) {
            JSONObject removeObject = removeRecords.getJSONObject(i);
            String rowId = removeObject.getString("rowId");
            matrixDataGateway.removeByRowId(rowId);
        }
        /*组装矩阵信息*/
        MatrixVO matrixVO = new MatrixVO();
        matrixVO.setId(cmd.getId());
        return matrixVO;
    }
}
