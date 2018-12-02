package com.welvx.intercity.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.welvx.intercity"))
                .paths(Predicates.or(PathSelectors.regex("/api/.*")))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("桔合旅行信息api文档")
                .description("restful风格")
                .termsOfServiceUrl("域名url")
                .contact(new Contact("intercity","welvx.com","bravoo@163.com"))
                .version("1.0")
                .build();
    }
}
