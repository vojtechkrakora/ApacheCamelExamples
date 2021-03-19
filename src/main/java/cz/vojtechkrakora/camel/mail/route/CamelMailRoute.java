package cz.vojtechkrakora.camel.mail.route;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import cz.vojtechkrakora.camel.mail.util.TemplateProviderUtil;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelMailRoute extends RouteBuilder {

    /**
     * @throws Exception an error while configuring a mail route
     */
    @Override
    public void configure() throws Exception {
        from("timer://foo?period=5000")  // Create a message every 5 seconds
                .setHeader("subject", simple("hello from camel"))
                .setBody(simple(TemplateProviderUtil.getTemplateContent(Templates.SIMPLE)))
                .setHeader("Content-Type", simple("text/html"))
                .setHeader("From", simple("no-reply@some.org"))
                .setHeader("To", simple("test@some.org"))
                .to("smtp://localhost:5025");
    }
}
