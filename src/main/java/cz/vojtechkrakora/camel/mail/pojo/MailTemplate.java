package cz.vojtechkrakora.camel.mail.pojo;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
@Data
public class MailTemplate implements Serializable {
    @NotNull(message = "Templates name can't be null")
    private String name;
    @NotNull(message = "Templates path can't be null")
    private String path;
    @NotNull(message = "Templates contenType can't be null")
    private String contentType;
    private boolean attachment;
}
