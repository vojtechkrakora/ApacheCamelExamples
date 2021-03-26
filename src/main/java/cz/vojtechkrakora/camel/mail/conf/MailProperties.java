package cz.vojtechkrakora.camel.mail.conf;

import cz.vojtechkrakora.camel.mail.pojo.MailTemplate;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Validated
@Data
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    private Map<String, MailTemplate> templates;
}
