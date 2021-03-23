package cz.vojtechkrakora.camel.mail.route;

import cz.vojtechkrakora.camel.mail.processor.SimpleMailProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelMailRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:sendMail")
                .log("Route started.")
                .process(new SimpleMailProcessor())
                .to("smtp://localhost:5025");
    }
}
