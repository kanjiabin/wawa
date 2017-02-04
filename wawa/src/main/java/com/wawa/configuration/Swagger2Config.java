package com.wawa.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.directModelSubstitute(LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(LocalDateTime.class, java.util.Date.class)
				.select().apis(requestHandler -> {
					String packageName = requestHandler.getHandlerMethod().getMethod().getDeclaringClass().getPackage()
							.getName();
					return packageName.startsWith("com.wawa") && packageName.contains("controller");
				})
				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("蛙蛙学车的RESTful APIs")
                .description("详细说明请看接口文档")
                .contact("阚嘉彬")
                .version("1.0")
                .build();
    }
}
