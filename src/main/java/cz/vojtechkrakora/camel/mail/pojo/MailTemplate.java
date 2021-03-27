package cz.vojtechkrakora.camel.mail.pojo;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
@Data
public class MailTemplate implements Serializable {
    @NotNull(message = "Templates name can't be null")
    private Templates type;
    @NotNull(message = "Templates path can't be null")
    private String path;
    @NotNull(message = "Templates contentType can't be null")
    private String contentType;
    private boolean attachment;
}
