package com.javainuse.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicate;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
    public Docket usersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(usersApiInfo())
                .select()
                .paths(userPaths())
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }


    /**
     * Api info
     * @return ApiInfo
     */
    private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("Service User")
                .version("1.0")
                .license("Apache License Version 2.0")
                .build();
    }


	/*@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.javainuse.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}*/

	
	   /*private ApiInfo usersApiInfo() {
	        return new ApiInfoBuilder()
	                .title("Service User")
	                .version("1.0")
	                .license("Apache License Version 2.0")
	                .build();
	    }*/
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Order Service API",
				"Order Service API Description",
				"1.0",
				"",
				new Contact("Codmind", "https://codmind.com", "apis@codmind.com"),
				"Apache License Version 2.0",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
	

    private Predicate<String> userPaths() {
        return regex("/employees.*");
    }

	

	
}