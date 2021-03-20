package cz.vojtechkrakora.camel.mail.processor;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import cz.vojtechkrakora.camel.mail.util.TemplateProviderUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SimpleMailProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setHeader("subject", "hello from camel");
        exchange.getIn().setHeader("Content-Type", "text/html");
        exchange.getIn().setHeader("From", "no-reply@some.org");
        exchange.getIn().setHeader("To", "test@some.org");
        exchange.getIn().setBody(TemplateProviderUtil.getTemplateContent(Templates.SIMPLE));
    }
}
