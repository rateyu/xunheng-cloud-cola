package com.xunheng.base.config;


// 使用注解的方式实现描Swagger的配置

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;

// 使用代码实现接口的描述及Swagger的配置
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.Paths;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;


/**
 * @author Anhui OuYang
 * @version 1.0
 **/
@Configuration
@OpenAPIDefinition(
        // ## API的基本信息，包括标题、版本号、描述、联系人等
        info = @Info(
                title = "xunheng-cloud",       // Api接口文档标题（必填）
                description = "寻衡cloud管理后台框架",      // Api接口文档描述
                version = "2.0",                                   // Api接口版本
                termsOfService = "https://www.xunheng.cloud",             // Api接口的服务条款地址
                contact = @Contact(
                        name = "hhqkkr",                            // 作者名称
                        email = "452794162@qq.com",                  // 作者邮箱
                        url = "https://www.xunheng.cloud"  // 介绍作者的URL地址
                ),
                license = @License(                                                // 设置联系人信息
                        name = "Apache 2.0",                                       // 授权名称
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"   // 授权信息
                )
        ))
@SecurityScheme(
        name = "xunhengToken",                   // 认证方案名称
        type = SecuritySchemeType.HTTP,      // 认证类型，当前为http认证
        description = "sa的token",  // 描述信息
        in = SecuritySchemeIn.HEADER,        // 代表在http请求头部
        scheme = "bearer",                   // 认证方案，如：Authorization: bearer token信息
        bearerFormat = "JWT")                // 表示使用 JWT 格式作为 Bearer Token 的格式
public class SwaggerOpenApiConfig {

//    /***
//     * 构建Swagger3.0文档说明
//     * @return 返回 OpenAPI
//     */
//    @Bean
//    public OpenAPI customOpenAPI() {
//
//        // 联系人信息(contact)，构建API的联系人信息，用于描述API开发者的联系信息，包括名称、URL、邮箱等
//        // name：文档的发布者名称 url：文档发布者的网站地址，一般为企业网站 email：文档发布者的电子邮箱
//        Contact contact = new Contact()
//                .name("蚂蚁小哥")                             // 作者名称
//                .email("xiaofeng@qq.com")                   // 作者邮箱
//                .url("https://www.cnblogs.com/antLaddie/")  // 介绍作者的URL地址
//                .extensions(new HashMap<String, Object>()); // 使用Map配置信息（如key为"name","email","url"）
//
//        // 授权许可信息(license)，用于描述API的授权许可信息，包括名称、URL等；假设当前的授权信息为Apache 2.0的开源标准
//        License license = new License()
//                .name("Apache 2.0")                         // 授权名称
//                .url("https://www.apache.org/licenses/LICENSE-2.0.html")    // 授权信息
//                .identifier("Apache-2.0")                   // 标识授权许可
//                .extensions(new HashMap<String, Object>());// 使用Map配置信息（如key为"name","url","identifier"）
//
//        //创建Api帮助文档的描述信息、联系人信息(contact)、授权许可信息(license)
//        Info info = new Info()
//                .title("Swagger3.0 (Open API) 框架学习示例文档")      // Api接口文档标题（必填）
//                .description("学习Swagger框架而用来定义测试的文档")     // Api接口文档描述
//                .version("1.2.1")                                  // Api接口版本
//                .termsOfService("https://example.com/")            // Api接口的服务条款地址
//                .license(license)                                  // 设置联系人信息
//                .contact(contact);                                 // 授权许可信息
//
//        //通过Paths可以配置多组接口信息(Paths接收PathItem，这里的每个PathItem我抽取方式出去了)
//        Paths paths = new Paths();
//        paths.put("根据传入的老师信息进行数据保存", InterfaceDescriptionConfig.addTeacher());
//
//        // 返回信息
//        return new OpenAPI()
//                .openapi("3.0.1")  // Open API 3.0.1(默认)
//                .paths(paths)
//                .info(info);       // 配置Swagger3.0描述信息
//    }
}
