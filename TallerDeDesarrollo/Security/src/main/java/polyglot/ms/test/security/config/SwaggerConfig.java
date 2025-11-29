package polyglot.ms.test.security.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio de Seguridad")
                        .version("1.0.0")
                        .description("API del microservicio de Seguridad"))
                .servers(List.of(
                        new Server().url("http://localhost:81").description("Microservicio Seguridad")));

    }
}
