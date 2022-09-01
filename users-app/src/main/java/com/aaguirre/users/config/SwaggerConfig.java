package com.aaguirre.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class SwaggerConfig {      
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.aaguirre.users.controllers"))              
          .paths(PathSelectors.ant("/users/*")) //can be any for any                          
          .build()
          .useDefaultResponseMessages(false);                                           
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("My API")
				.version("1.0")
				.license("Apache 2.0")
				.contact(new Contact("@alanAguirre", "https://radio.aguirremartinez.ga/public/radio", "aaguirre1615@gmail.com"))
				.build();
	}
}