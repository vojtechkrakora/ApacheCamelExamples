package cz.vojtechkrakora.camel.mail.processor;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import cz.vojtechkrakora.camel.mail.util.TemplateProviderUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.attachment.AttachmentMessage;
import org.springframework.core.io.ClassPathResource;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

public class SimpleMailProcessor implements Processor {
    public static final String ATTACHMENT_EXAMPLE_PATH = "attachment/ok_small.png";
    public static final String ATTACHMENT_EXAMPLE_TYPE = "image/png";
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setHeader("subject", "hello from camel");
        exchange.getIn().setHeader("Content-Type", "text/html");
        exchange.getIn().setHeader("From", "no-reply@some.org");
        exchange.getIn().setHeader("To", "test@some.org");
        exchange.getIn().setBody(TemplateProviderUtil.getTemplateContent(Templates.SIMPLE));
        AttachmentMessage am = exchange.getMessage(AttachmentMessage.class);
        ClassPathResource attachment = new ClassPathResource(ATTACHMENT_EXAMPLE_PATH);
        ByteArrayDataSource ba = new ByteArrayDataSource(attachment.getInputStream(), ATTACHMENT_EXAMPLE_TYPE);
        am.addAttachment("ok.png", new DataHandler(ba));
    }
}
