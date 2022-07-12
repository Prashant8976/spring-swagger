package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class BookConfig {
	@Bean
	   public Docket productApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	    		  .groupName("swagger group")
	    		  .apiInfo(apiInfo()).select()
	    		  .apis(RequestHandlerSelectors.basePackage("com.example"))
                  .paths(PathSelectors.regex("/book.*")).build()
                  ;
	    		 // .paths(regex("/book")).build();
	   }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Book service Title")
				.description("sample docs using swagger2")
				.termsOfServiceUrl("www.myfirstswagger.com")
				.license("licence")
				.licenseUrl("www.google.com")
				.build();
	}

}
