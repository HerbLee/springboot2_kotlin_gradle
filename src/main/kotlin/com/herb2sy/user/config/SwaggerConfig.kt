package com.herb2sy.user.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {


    @Bean
    fun createRestApi():Docket{

        return Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(true).select()
                .apis(RequestHandlerSelectors.basePackage("com.herb2sy.user.controller")).paths(PathSelectors.any()).build().pathMapping("/")

    }

    private fun apiInfo():ApiInfo{
        return ApiInfoBuilder().title("herb2sy api 接口").description("测试使用,改这里").contact(Contact("herb2sy","https://www.herb2sy.com","herb2sy@gmail.com"))
                .version("1.0.0").build()
    }


}