package cz.vojtechkrakora.camel.mail.processor;

import cz.vojtechkrakora.camel.mail.conf.MailProperties;
import cz.vojtechkrakora.camel.mail.pojo.MailTemplate;
import cz.vojtechkrakora.camel.util.TemplateProviderUtil;
import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.attachment.AttachmentMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SimpleMailProcessor implements Processor {
    public static final String ATTACHMENT_EXAMPLE_PATH = "attachment/ok_small.png";
    public static final String ATTACHMENT_EXAMPLE_TYPE = "image/png";

    private final MailProperties mailProperties;

    @Override
    public void process(Exchange exchange) throws Exception {
        Message ctx = exchange.getIn();
        MailTemplate template = getTemplate(ctx.getBody(String.class))
                .orElseThrow(() -> new RuntimeException("Template not found"));
        ctx.setHeader("subject", "hello from camel");
        ctx.setHeader("Content-Type", template.getContentType());
        ctx.setHeader("From", "no-reply@some.org");
        ctx.setHeader("To", "test@some.org");
        ctx.setBody(TemplateProviderUtil.getTemplateContent(template.getPath()));
        AttachmentMessage am = exchange.getMessage(AttachmentMessage.class);
        ClassPathResource attachment = new ClassPathResource(ATTACHMENT_EXAMPLE_PATH);
        ByteArrayDataSource ba = new ByteArrayDataSource(attachment.getInputStream(), ATTACHMENT_EXAMPLE_TYPE);
        am.addAttachment("ok.png", new DataHandler(ba));
    }

    private Optional<MailTemplate> getTemplate(String templateName) {
        return Optional.ofNullable(mailProperties.getTemplates().get(templateName));
    }
}
