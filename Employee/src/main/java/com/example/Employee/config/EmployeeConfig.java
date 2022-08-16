package com.example.Employee.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class EmployeeConfig {
	  @Bean
	    Docket postsApi() {
	        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
	                .apiInfo(apiInfo()).select().paths(regex("/api/v1/student.*")).build();
	    }

		
		
		private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("HeyTorus API")
					.description("Student API reference for developers")
					.license("Torus License")
					.licenseUrl("heytorus@gmail.com").version("1.0").build();
		
		}
}
