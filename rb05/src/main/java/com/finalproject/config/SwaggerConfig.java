package com.finalproject.config;


import org.springframework.context.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class SwaggerConfig {
    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.finalproject.controller"))//controller paketi neredeyse o paketi ver
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Exchange Rate API Documentation")
                .license("API documentation using Swagger 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}
