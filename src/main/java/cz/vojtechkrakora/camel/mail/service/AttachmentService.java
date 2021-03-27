package cz.vojtechkrakora.camel.mail.service;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import org.apache.camel.Exchange;
import org.apache.camel.attachment.AttachmentMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;

@Service
public class AttachmentService {
    public static final String ATTACHMENT_EXAMPLE_PATH = "attachment/ok_small.png";
    public static final String ATTACHMENT_EXAMPLE_TYPE = "image/png";
    public static final String SIMPLE_TEMPLATE_ATTACHMENT_NAME = "ok.png";

    /**
     * Adds an attachment for required Template, if template type does not have an attachments adds nothing.
     * @param ex exchange from camel context
     * @param template template for which will be the attachment created
     * @return exchange with possible attachment
     * @throws IOException If some error occurs while retrieving an attachment
     */
    public Exchange addAttachment(Exchange ex, final Templates template) throws IOException {

        if (template == Templates.SIMPLE) {
            return addSimpleTemplateAttachment(ex);
        }

        return ex;
    }


    private Exchange addSimpleTemplateAttachment(Exchange ex) throws IOException {
        AttachmentMessage am = ex.getMessage(AttachmentMessage.class);
        ClassPathResource attachment = new ClassPathResource(ATTACHMENT_EXAMPLE_PATH);
        ByteArrayDataSource ba = new ByteArrayDataSource(attachment.getInputStream(), ATTACHMENT_EXAMPLE_TYPE);
        am.addAttachment(SIMPLE_TEMPLATE_ATTACHMENT_NAME, new DataHandler(ba));

        return ex;
    }
}
