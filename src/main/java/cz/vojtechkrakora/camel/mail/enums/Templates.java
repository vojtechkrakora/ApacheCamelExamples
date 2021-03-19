package cz.vojtechkrakora.camel.mail.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Templates {
    SIMPLE("mail/templates/simpleTemplate.html");
    String path;
}
