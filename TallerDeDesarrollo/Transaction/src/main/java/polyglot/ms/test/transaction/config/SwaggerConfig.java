package polyglot.ms.test.transaction.config;

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
                        .title("Microservicio de Transacciones")
                        .version("1.0.0")
                        .description("API del microservicio de transacciones"))
                .servers(List.of(
                        new Server().url("http://localhost:84").description("Microservicio Transaction")));

    }
}
