package cz.vojtechkrakora.camel.mail.controller;

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

    @GetMapping(path = "/send")
    public void getBook() {
        producerTemplate.sendBody(SEND_MAIL_ENDPOINT,"callTemplate");
    }
}
