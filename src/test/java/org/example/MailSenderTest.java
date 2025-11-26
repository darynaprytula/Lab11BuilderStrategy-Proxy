package org.example;

import org.example.mail.Client;
import org.example.mail.MailCode;
import org.example.mail.MailInfo;
import org.example.mail.MailSender;
import org.example.mail.MailTemplate;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MailSenderTest {

    @Test
    void testMailIsSent() {
        FakeEmailSender fake = new FakeEmailSender();
        MailTemplate template = info -> "Hello " + info.getClient().getName();
        Map<MailCode, MailTemplate> templates = Map.of(MailCode.GIFT, template);

        MailSender sender = new MailSender(fake, templates);

        Client client = new Client("Roman", 20, Gender.MALE);
        MailInfo info = new MailInfo(client, MailCode.GIFT);

        sender.sendMail(info);

        assertEquals(1, fake.count);
        assertEquals("roman@gmail.com", fake.lastReceiver);
        assertEquals("Hello Roman", fake.lastText);
    }

    @Test
    void testMissingTemplateThrows() {
        FakeEmailSender fake = new FakeEmailSender();
        MailSender sender = new MailSender(fake, Map.of());

        Client client = new Client("Roman", 20, Gender.MALE);
        MailInfo info = new MailInfo(client, MailCode.GIFT);

        assertThrows(IllegalArgumentException.class,
                () -> sender.sendMail(info));
    }
}
