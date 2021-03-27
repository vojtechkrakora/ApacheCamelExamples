package cz.vojtechkrakora.camel.mail.processor;

import cz.vojtechkrakora.camel.mail.conf.MailProperties;
import cz.vojtechkrakora.camel.mail.pojo.MailTemplate;
import cz.vojtechkrakora.camel.mail.service.AttachmentService;
import cz.vojtechkrakora.camel.util.TemplateProviderUtil;
import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SimpleMailProcessor implements Processor {
    private final MailProperties mailProperties;
    private final AttachmentService attachmentService;

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
        attachmentService.addAttachment(exchange, template.getType());
    }

    private Optional<MailTemplate> getTemplate(String templateName) {
        return Optional.ofNullable(mailProperties.getTemplates().get(templateName));
    }
}
