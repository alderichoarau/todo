package com.test.todo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SwaggerConfig {

    /**
     * Swagger config
     *
     * @return custom {@link OpenAPI}
     */
    @Bean
    public OpenAPI customOpenAPI() {
        log.info("Provide custom Swagger UI configuration");
        return new OpenAPI()
                .addServersItem(new Server()
                        .url("http://localhost:8080/api/")
                        .description("Local simulation Server"))
                .info(new Info().title("Todo Swagger")
                        .contact(new Contact().name("Viewer administration").email("todo@airfrance.Fr").url("https://"))
                        .description("REST api documentation for todo backend. You can find more about Swagger at [https://swagger.io](https://swagger.io).")
                        .version("v0.5.1"));
    }
}
