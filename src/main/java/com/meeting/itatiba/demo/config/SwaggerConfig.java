package com.meeting.itatiba.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket detalheApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.meeting.itatiba.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInformation().build());

        return docket;
    }

    private ApiInfoBuilder apiInformation() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Api-restBasic");
        apiInfoBuilder.description("Api para realização de estudos com CRUD");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.");
        apiInfoBuilder.license("Licença - Open Source");
        apiInfoBuilder.licenseUrl("https://www.linkedin.com/in/isaias-luiz-dos-santos-52b1b417b/");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }

    private Contact contact() {

        return new Contact(
                "Isaías Luiz",
                "",
                "isaiaslds63@gmail.com");
    }
}
