package cz.vojtechkrakora.camel.mail.controller;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import lombok.AllArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("camel-mail")
public class MailRestController {
    public static final String SEND_MAIL_ENDPOINT = "direct:sendMail";
    final ProducerTemplate producerTemplate;

    @GetMapping(path = "/send/SIMPLE")
    public void getBook() {
        producerTemplate.sendBody(SEND_MAIL_ENDPOINT, Templates.SIMPLE.getName());
    }
}
