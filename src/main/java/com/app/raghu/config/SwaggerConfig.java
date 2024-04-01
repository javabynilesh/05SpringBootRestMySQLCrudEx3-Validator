package com.app.raghu.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*@Configuration
@EnableSwagger2*/
public class SwaggerConfig {
	/*
	@Bean
	public Docket configureDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.app.raghu"))
				.paths(PathSelectors.regex("/rest/student"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("MY APP TEST",
							"HELLO USERS",
							"3.2GA",
							"http://abcd.com",
							new Contact("RAGHU", "http://abcd.com", "javabyraghu@gmail.com"),
							"R-LICENSE",
							"http://abc.com",
							Collections.emptyList()
						);
	}*/
}
