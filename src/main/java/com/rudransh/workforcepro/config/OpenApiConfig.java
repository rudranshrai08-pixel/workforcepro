package com.rudransh.workforcepro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI workforceOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()

                .info(new Info()
                        .title("WorkforcePro API")
                        .description("Enterprise Workforce Management System REST API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Rudransh Rai")
                                .email("rudransh1@gmail.com")))

                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))

                .schemaRequirement(
                        securitySchemeName,
                        new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"));
    }
}