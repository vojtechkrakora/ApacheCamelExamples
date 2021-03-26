package cz.vojtechkrakora.camel.util;

import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;

@UtilityClass
public class TemplateProviderUtil {
    public static String getTemplateContent(String path) throws IOException {
        ClassPathResource simpleTemplate = new ClassPathResource(path);
        return Files.readString(simpleTemplate.getFile().toPath());
    }
}
