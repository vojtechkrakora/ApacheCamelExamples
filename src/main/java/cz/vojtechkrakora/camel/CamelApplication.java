package cz.vojtechkrakora.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("cz.vojtechkrakora.camel.mail.conf")
public class CamelApplication {
    public static void main(String[] args) {
        SpringApplication.run(CamelApplication.class, args);
    }
}
