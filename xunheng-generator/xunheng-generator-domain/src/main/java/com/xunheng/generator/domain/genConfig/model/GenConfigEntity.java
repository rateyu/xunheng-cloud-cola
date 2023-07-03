package com.xunheng.generator.domain.genConfig.model;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.xunheng.base.exception.GlobalException;
import io.seata.common.util.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class GenConfigEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "实体名")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "表名前缀")
    private String tablePrefix;

    @ApiModelProperty(value = "表名简称")
    private String tableAlias;

    @ApiModelProperty(value = "服务名")
    private String serviceName;

    @ApiModelProperty(value = "服务根路径")
    private String servicePackage;

    @ApiModelProperty(value = "包路径")
    private String packageName;

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "类对象名")
    private String lowerCaseName;

    @TableField(exist = false)
    @ApiModelProperty(value = "表字段")
    private List<GenFieldConfigEntity> fieldList;

    public String getSysPath(String nodeName){
        return System.getProperty("user.dir") +"/xunheng-"+serviceName+"/src/main/"+nodeName+"/";
    }

    public String getServicePackage(){
        return "com.xunheng." + serviceName;
    }

    public String getPackage(String name){
        if(name.equals("mapper"))name = "dao.mapper";
        else if(name.equals("serviceImpl"))name = "service.impl";
        else if(name.equals("mapperXml"))return "mapper";
        return getServicePackage() + "."+name;
    }

    public void setTableName(String tablePrefix,String name){
       this.tableName =  tablePrefix + camel2Underline(name);
    }

    public void setLowerCaseName(String name){
        this.lowerCaseName = name(name,false);
    }



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

    /**
     * 驼峰法转下划线
     */
    public String camel2Underline(String str) {
        if (StringUtils.isBlank(str))return "";
        if (str.length() == 1)return str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                sb.append("_" + Character.toLowerCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return (str.charAt(0) + sb.toString()).toLowerCase();
    }

    /**
     * 点转斜线
     * @param str 文本
     * @return 转换后的文本
     */
    public String dotToLine(String str) {
        return str.replace(".", "/");
    }
}
