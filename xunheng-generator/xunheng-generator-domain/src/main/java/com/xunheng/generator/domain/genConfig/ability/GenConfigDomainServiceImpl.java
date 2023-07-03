package com.xunheng.generator.domain.genConfig.ability;

import com.xunheng.generator.domain.genConfig.gateway.GenConfigGateway;
import com.xunheng.generator.domain.genConfig.gateway.GenFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
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

    @Override
    public void saveAndGen(GenConfigEntity entity)  {
        try {
            /*先进行保存*/
            this.save(entity);
            /*加载对应的模版配置*/
            GroupTemplate groupTemplate = initConfig();
            /*生成代码*/
            executeMVC(groupTemplate,entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(GenConfigEntity entity) {
        /*先删除原来的字段配置*/
        genFieldConfigGateway.removeAllFields();
        /*保存字段信息*/
        genFieldConfigGateway.batchCreate(entity.getFieldList());
        /*保存基础配置*/
        genConfigGateway.save(entity);
    }

    /**
     * 根据条件初始化模版组的配置 也就是找到你配置的MVC或者COLA的模版
     * @return 模版组
     */
    private GroupTemplate initConfig() throws IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/btl/");
        Configuration cfg = Configuration.defaultConfiguration();
        return new GroupTemplate(resourceLoader, cfg);
    }

    /**
     * 生成mvc模式对应的代码
     * @param t 模版组
     * @param entity 配置实体
     */
    private void executeMVC(GroupTemplate t,GenConfigEntity entity) throws IOException{
        generateFile(t,"entity",entity,".java");
        generateFile(t,"mapper",entity,"Mapper.java");
        generateFile(t,"service",entity,"Service.java");
        generateFile(t,"serviceImpl",entity,"ServiceImpl.java");
        generateFile(t,"controller",entity,"Controller.java");
        generateFile(t,"mapperXml",entity,"Mapper.xml");
    }

    private void generateFile(GroupTemplate groupTemplate,String templateName,GenConfigEntity entity,String suffix) throws IOException {
        /*根据所需要生成的文件 配置文件的包名*/
        entity.setPackageName(entity.getPackage(templateName));
        OutputStream out = null;
        /*加载模版组中对应的模版*/
        Template entityTemplate = groupTemplate.getTemplate(templateName+".btl");
        /*配置模版的数据源*/
        entityTemplate.binding("config", entity);
        /*确定文件根目录*/
        String nodeName = templateName.equals("mapperXml") ? "resources" : "java";//文件的根目录 java文件在java下 xml文件在resource下
        /*组装文件的物理路径*/
        String entityFileUrl = entity.getSysPath(nodeName) + entity.dotToLine(entity.getPackageName()) + "/" + entity.name(entity.getName(), true) + suffix;
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


}
