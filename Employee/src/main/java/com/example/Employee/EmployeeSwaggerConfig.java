package com.example.Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class EmployeeSwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/v1/employees.*"), regex("/api/v1/employees.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("HeyTorus API")
				.description("Employee API reference for developers")
				.contact("heytorus@gmail.com").license("Torus License")
				.licenseUrl("heytorus@gmail.com").version("1.0").build();
	
	}
}
