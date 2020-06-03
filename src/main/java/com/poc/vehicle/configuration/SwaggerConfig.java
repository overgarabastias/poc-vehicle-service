package com.poc.vehicle.configuration;


import com.google.common.base.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Value("${app.version}")
	private String appVersion;
	
	@Value("${app.artifactId}")
	private String artifactId;
	
	@Value("${app.description}")
	private String description;
	
	/**
     * Publish a bean to generate swagger2 endpoints
     * @return a swagger configuration bean
     */
    @Bean
    public Docket EngineApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(EngineApiInfo())
                .select()
                .paths(paths())
                .apis(RequestHandlerSelectors.any())
                .build();
    }
 
   private ApiInfo EngineApiInfo() {
        return new ApiInfoBuilder()
                .title(artifactId)
                .description(description)
                .version(appVersion)
                .build();
    }
   
   private Predicate<String> paths() {
	    return regex("/poc.*");
	  }
   

}
