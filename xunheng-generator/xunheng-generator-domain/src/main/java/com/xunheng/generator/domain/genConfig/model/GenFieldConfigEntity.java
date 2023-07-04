package com.xunheng.generator.domain.genConfig.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.base.exception.GlobalException;
import io.seata.common.util.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class GenFieldConfigEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段描述")
    private String description;

    @ApiModelProperty(value = "字段类型")
    private String type;

    @ApiModelProperty(value = "默认值")
    private String defaultVal;

    @ApiModelProperty(value = "是否索引 0:否 1:是")
    private Integer cindex;

    @ApiModelProperty(value = "是否不能为空 0:否 1:是")
    private Integer notNull;

    @ApiModelProperty(value = "字段大写名称")
    private String fieldUpperCaseName;

    /**
     * 名称首字母大小写转换
     * @param name DO名称
     * @param isFirstUpper 首字母是否大小写
     * @return
     */
    public String name(String name, boolean isFirstUpper) {
        if (StringUtils.isBlank(name)) throw new GlobalException("name不能为空");
        if (name.length() == 1) {
            if (isFirstUpper) {
                return name.toUpperCase();
            } else {
                return name.toLowerCase();
            }
        }
        StringBuilder sb = new StringBuilder();
        if (isFirstUpper) {
            sb.append(Character.toUpperCase(name.charAt(0)));
        } else {
            sb.append(Character.toLowerCase(name.charAt(0)));
        }
        sb.append(name.substring(1));
        return sb.toString();
    }
}
