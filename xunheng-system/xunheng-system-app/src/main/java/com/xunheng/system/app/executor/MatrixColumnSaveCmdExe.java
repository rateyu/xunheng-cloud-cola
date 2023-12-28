package com.xunheng.system.app.executor;


import com.xunheng.base.exception.GlobalException;
import com.xunheng.system.app.assembler.MatrixColumnAssembler;
import com.xunheng.system.client.dto.MatrixColumnSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixColumnVO;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.domain.matrix.gateway.MatrixColumnGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵列保存处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:09
 */
@Component
public class MatrixColumnSaveCmdExe {

    @Resource
    private MatrixColumnGateway matrixColumnGateway;

    public MatrixVO execute(MatrixColumnSaveCmd cmd) {
        //删除原矩阵中的列信息 由于列数据是根据标识绑定 所以不会受到影响
        matrixColumnGateway.removeByMatrixId(cmd.getId());
        List<MatrixColumnVO> columns = cmd.getColumnList();
        /*遍历数据保存*/
        for (MatrixColumnVO column : columns) {
            //检验有没有标识重复
            List<String> columnCodes = columns.stream().map(MatrixColumnVO::getTag).collect(Collectors.toList());
            String field = column.getTag();
            int count = Collections.frequency(columnCodes,field);
            if(count > 1)throw new GlobalException("列标识【"+field+"】重复");
            //保存
            matrixColumnGateway.create(MatrixColumnAssembler.toSaveEntity(column));
        }
        /*组装矩阵信息*/
        MatrixVO matrixVO = new MatrixVO();
        matrixVO.setId(cmd.getId());
        matrixVO.setColumnList(columns);
        return matrixVO;
    }
}
