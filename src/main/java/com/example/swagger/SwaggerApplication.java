package com.example.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
	@Bean
	public Docket swaggerconfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.example.swagger"))
				.build()
				.apiInfo(getApiInfo());

	}
	private ApiInfo getApiInfo() {
		springfox.documentation.service.Contact contact = new Contact("Demo Project API", "http://brigelbaz.com", "nilofarmujwar1118@gmail.com");
		return new ApiInfoBuilder().title("Demo Service Swagger API")
				.description("Demo Service Swagger API for Learning Swagger").version("0.0.1.SNAPSHOT")
				.license("Apache 2.0").licenseUrl(" http://www.apache.org/licenses/LICENSE-2.0").contact(contact)
				.build();
	}

}
