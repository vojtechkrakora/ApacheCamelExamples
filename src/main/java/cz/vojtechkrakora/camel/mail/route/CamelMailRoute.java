package cz.vojtechkrakora.camel.mail.route;

import cz.vojtechkrakora.camel.mail.processor.SimpleMailProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelMailRoute extends RouteBuilder {

    /**
     * @throws Exception an error while configuring a mail route
     */
    @Override
    public void configure() throws Exception {
        from("direct:sendMail")  // Create a message every 5 seconds
                .log("Route started.")
                .process(new SimpleMailProcessor())
                .to("smtp://localhost:5025");
    }
}
