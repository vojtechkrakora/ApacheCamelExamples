package cz.vojtechkrakora.camel.mail.util;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;

@UtilityClass
public class TemplateProviderUtil {
    public static String getTemplateContent(Templates template) throws IOException {
        ClassPathResource simpleTemplate = new ClassPathResource(template.getPath());
        return Files.readString(simpleTemplate.getFile().toPath());
    }
}
