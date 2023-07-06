package com.xunheng.generator.domain.genConfig.ability;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.utils.FileUtil;
import com.xunheng.generator.domain.genConfig.gateway.GenConfigGateway;
import com.xunheng.generator.domain.genConfig.gateway.GenFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.gateway.GenFrontFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.model.FrontCodeEntity;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
import com.xunheng.generator.domain.genConfig.model.GenType;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器领域服务实现类
 * @author: hhqkkr
 * @date: 2023/7/3 18:26
 */
@Component
public class GenConfigDomainServiceImpl implements GenConfigDomainService{

    @Resource
    GenConfigGateway genConfigGateway;

    @Resource
    GenFieldConfigGateway genFieldConfigGateway;

    @Resource
    GenFrontFieldConfigGateway genFrontFieldConfigGateway;

    @Override
    public void saveAndGen(GenConfigEntity entity)  {
        try {
            /*先进行保存*/
            this.save(entity);
            /*校验*/
            genCheck(entity);
            /*根据架构类型加载对应的模版配置*/
            GroupTemplate groupTemplate = initConfig(entity.getType());
            /*生成代码*/
            executeByType(groupTemplate,entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FrontCodeEntity saveAndGenFront(GenConfigEntity entity) {
        try {
            /*先进行保存*/
            this.save(entity);
            /*根据架构类型加载对应的模版配置*/
            GroupTemplate groupTemplate = initConfig(GenType.VUE);
            /*生成代码*/
            return executeFront(groupTemplate, entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 校验类型是否选择正确
     * @param entity 参数
     */
    private void genCheck(GenConfigEntity entity) {
        GenType type = entity.getType();
        if(type.equals(GenType.COLA)){
            String checkDir = System.getProperty("user.dir") +"/xunheng-"+entity.getServiceName()+"/xunheng-"+entity.getServiceName()+"-start/src";
            File file = new File(checkDir);
            if(!file.exists())throw new GlobalException("所选择的服务架构不是COLA架构，无法生成。");
        }else if(type.equals(GenType.MVC)){
            String checkDir = System.getProperty("user.dir") +"/xunheng-"+entity.getServiceName()+"/src/main/";
            File file = new File(checkDir);
            if(!file.exists())throw new GlobalException("所选择的服务架构不是MVC架构，无法生成。");
        }
    }


    @Override
    public void save(GenConfigEntity entity) {
        /*删除原来的后端字段配置*/
        genFieldConfigGateway.removeAllFields();
        /*删除原来的前端字段配置*/
        genFrontFieldConfigGateway.removeAllFields();
        /*保存后端字段信息*/
        genFieldConfigGateway.batchCreate(entity.getFieldList());
        /*保存前端字段信息*/
        genFrontFieldConfigGateway.batchCreate(entity.getFrontFieldList());
        /*保存基础配置*/
        genConfigGateway.save(entity);
    }

    /**
     * 根据条件初始化模版组的配置 也就是找到你配置的MVC或者COLA的模版
     * @return 模版组
     */
    private GroupTemplate initConfig(GenType type) throws IOException {
        String root = "";
        switch (type) {
            case VUE:
                root = "/btl/vue/";
                break;
            case COLA:
                root = "/btl/cola/";
                break;
            case MVC:
                root = "/btl/mvc/";
                break;
        }
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader(root);
        Configuration cfg = Configuration.defaultConfiguration();
        return new GroupTemplate(resourceLoader, cfg);
    }

    /**
     * 根据架构类型生成代码
     * @param groupTemplate 模版组
     * @param entity 数据源
     */
    private void executeByType(GroupTemplate groupTemplate, GenConfigEntity entity) {
        try {
            /*获取架构类型*/
            GenType type = entity.getType();
            /*走对应方法*/
            if(type.equals(GenType.COLA))executeCOLA(groupTemplate,entity);
            else executeMVC(groupTemplate,entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成cola模式对应的代码
     * @param t 模版组
     * @param entity 配置实体
     */
    private void executeCOLA(GroupTemplate t,GenConfigEntity entity) throws IOException{
        generateFile(t,"assembler","app",entity,"Assembler.java");
        generateFile(t,"controller","adapter",entity,"Controller.java");
        generateFile(t,"service","client",entity,"Service.java");
        generateFile(t,"pageQuery","client",entity,"PageQuery.java");
        generateFile(t,"updateCmd","client",entity,"UpdateCmd.java");
        generateFile(t,"createCmd","client",entity,"CreateCmd.java");
        generateFile(t,"VO","client",entity,"VO.java");
        generateFile(t,"mapperXml","infrastructure",entity,"Mapper.xml");
        generateFile(t,"pageQueryExe","app",entity,"PageQueryExe.java");
        generateFile(t,"detailQueryExe","app",entity,"DetailQueryExe.java");
        generateFile(t,"removeCmdExe","app",entity,"RemoveCmdExe.java");
        generateFile(t,"serviceImpl","app",entity,"ServiceImpl.java");
        generateFile(t,"updateCmdExe","app",entity,"UpdateCmdExe.java");
        generateFile(t,"createCmdExe","app",entity,"CreateCmdExe.java");
        generateFile(t,"entity","domain",entity,"Entity.java");
        generateFile(t,"gateway","domain",entity,"Gateway.java");
        generateFile(t,"convertor","infrastructure",entity,"Convertor.java");
        generateFile(t,"DO","infrastructure",entity,".java");
        generateFile(t,"gatewayImpl","infrastructure",entity,"GatewayImpl.java");
        generateFile(t,"mapper","infrastructure",entity,"Mapper.java");

    }

    /**
     * 生成mvc模式对应的代码
     * @param t 模版组
     * @param entity 配置实体
     */
    private void executeMVC(GroupTemplate t,GenConfigEntity entity) throws IOException{
        generateFile(t,"entity",null,entity,".java");
        generateFile(t,"mapper",null,entity,"Mapper.java");
        generateFile(t,"service",null,entity,"Service.java");
        generateFile(t,"serviceImpl",null,entity,"ServiceImpl.java");
        generateFile(t,"controller",null,entity,"Controller.java");
        generateFile(t,"mapperXml",null,entity,"Mapper.xml");
    }

    /**
     * 生成前端vue对应的代码
     * @param t 模版组
     * @param entity 配置实体
     */
    private FrontCodeEntity executeFront(GroupTemplate t,GenConfigEntity entity) throws IOException{
        String codeApi = generateFrontCode(t, "api", entity);
        String codeIndex = generateFrontCode(t, "index", entity);
        String codeSave = generateFrontCode(t, "save", entity);
        return new FrontCodeEntity(codeApi,codeSave,codeIndex);
    }

    /**
     * 生成后端代码 并直接生成文件
     * @param groupTemplate 模板组
     * @param templateName 模板名称
     * @param moduleName 服务内的模组名称 mvc模式为空
     * @param entity 数据源
     * @param suffix 文件后缀
     * @throws IOException 异常
     */
    private void generateFile(GroupTemplate groupTemplate,String templateName,String moduleName,GenConfigEntity entity,String suffix) throws IOException {
        OutputStream out = null;
        /*加载模版组中对应的模版*/
        Template entityTemplate = groupTemplate.getTemplate(templateName+".btl");
        /*配置模版的数据源*/
        entityTemplate.binding("config", entity);
        /*确定文件根目录*/
        String nodeName = templateName.equals("mapperXml") ? "resources" : "java";//文件的根目录 java文件在java下 xml文件在resource下
        /*组装文件的物理路径*/
        //xunheng-generator/xunheng-generator-client/src/main/java/com/xunheng/generator/client/api/TestService
        //xunheng-generator/src/main/java/com/xunheng/generator/service/TestService
        String entityFileUrl = entity.getSysPath(nodeName,entity.getType(),templateName,moduleName) + entity.name(entity.getName(), true) + suffix;
        /*生成文件夹与文件*/
        File entityFile = new File(entityFileUrl);
        File entityDir = entityFile.getParentFile();
        if (!entityDir.exists()) {
            entityDir.mkdirs();
        }
        /*文件不存在就生成*/
        if (!entityFile.exists()&&entityFile.createNewFile()) {
            out = new FileOutputStream(entityFile);
            entityTemplate.renderTo(out);
            out.close();
        }
    }

    /**
     * 生成前端代码 已文本方式反回
     * @param groupTemplate 模板组
     * @param templateName 模板名称
     * @param entity 数据源
     * @return 代码文本
     * @throws IOException io异常
     */
    private String generateFrontCode(GroupTemplate groupTemplate,String templateName,GenConfigEntity entity) throws IOException {
        /*加载模版组中对应的模版*/
        Template entityTemplate = groupTemplate.getTemplate(templateName+".btl");
        /*配置模版的数据源*/
        entityTemplate.binding("config", entity);
        return entityTemplate.render();
    }


}
