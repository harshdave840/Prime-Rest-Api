package com.assignment.prime.primegenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket primeNumberGeneratorApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.pathMapping("/")
                .select()                
                .apis(RequestHandlerSelectors.basePackage("com.assignment.prime.primegenerator"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private springfox.documentation.service.ApiInfo apiInfo() {
        return new springfox.documentation.service.ApiInfo(
                "Prime No API",
                "Rest API for Generating Prime Number",
                "1.0/",
                "Free to use",
                "Harsh",
                "",
                "");
    }

}
