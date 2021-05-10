package com.project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    //URL: http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Quan Ly Mua Ban Ve Xe Truc Tuyen")
                        .description("OpenAPI 3.0")
                        .contact(new Contact()
                                .email("1751010168tri@ou.edu.vn")
                                .name("Hoang Pham Minh Tri"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0.0"));
    }

}
