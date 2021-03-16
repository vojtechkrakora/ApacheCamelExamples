package cz.vojtechkrakora.camel.mail;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelMailRoute extends RouteBuilder {
    /**
     * Example from https://stackoverflow.com/questions/50098733/sending-email-with-camel/50117505
     * @throws Exception an error while configuring a mail route
     */
    @Override
    public void configure() throws Exception {
        from("timer://foo?period=5000")  // Create a message every 5 seconds
                .setHeader("subject", simple("hello from camel"))
                .setBody(simple("camel"))
                .log("sending?")
                .to("smtp://localhost:10025?From=user@custom.com&To=testuser@gmx.com");
    }
}
