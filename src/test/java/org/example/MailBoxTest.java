package org.example;

import org.example.mail.Client;
import org.example.mail.MailBox;
import org.example.mail.MailCode;
import org.example.mail.MailInfo;
import org.example.mail.MailSender;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class MailBoxTest {

    @Test
    public void testSendAllSendsEmails() {
        FakeEmailSender fake = new FakeEmailSender();
        MailSender sender = new MailSender(fake, TestTemplates.defaultTemplates());
        MailBox box = new MailBox(sender);

        Client client = new Client("Daryna", 20, Gender.FEMALE);
        MailInfo info = new MailInfo(client, MailCode.GIFT);

        box.addMailInfo(info);
        box.sendAll();

        assertEquals(1, fake.count);
    }
}
