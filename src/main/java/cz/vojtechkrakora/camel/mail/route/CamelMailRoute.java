package cz.vojtechkrakora.camel.mail.route;

import cz.vojtechkrakora.camel.mail.processor.SimpleMailProcessor;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CamelMailRoute extends RouteBuilder {

    private final SimpleMailProcessor simpleMailProcessor;

    @Override
    public void configure() {
        from("direct:sendMail")
                .log("Route started.")
                .process(simpleMailProcessor)
                .toD("velocity:mail/templates/${body}.vm")
                .to("smtp://localhost:5025");
    }
}
