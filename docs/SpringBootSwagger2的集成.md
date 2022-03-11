# SpringBootSwagger2

## 1.添加maven依赖包

```xml
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
```

## 2.在springboot入口或者配置类中增加@EnableSwagger2注解即可启用定时任务。

```java
@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication{
    public static void main(String[] args){
        SpringApplication.run(SwaggerApplication.class,args);
    }
}
```

## 3.编写Swagger配置类

```java
package com.xiaobai.servicebase;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//swagger2的配置文件，在项目的启动类的同级文件建立
@Configuration
@EnableSwagger2
//是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
@ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
public class SwaggerConfig {
    
    // swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }
    
     // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    public ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
            	// 页面标题
                .title("网站-课程中心API文档")
            	// 描述
                .description("本文档描述了课程中心微服务接口定义")
            	// 版本号
                .version("1.0")
            	// 创建人信息
                .contact(new Contact("Alva", "http://baidu.com", "1350221894@qq.com"))
                .build();
    }
}
```

> Swagger默认访问地址：http://localhost:8081/swagger-ui.html
