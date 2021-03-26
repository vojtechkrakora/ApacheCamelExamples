package cz.vojtechkrakora.camel.mail.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Templates {
    SIMPLE("simpleTemplate");
    String name;
}
