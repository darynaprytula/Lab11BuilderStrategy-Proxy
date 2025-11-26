package org.example.mail;

import java.util.Map;

public class MailSender {
    private final EmailSender emailSender;
    private final Map<MailCode, MailTemplate> templates;

    public MailSender(EmailSender emailSender, Map<MailCode, MailTemplate> templates) {
        this.emailSender = emailSender;
        this.templates = templates;
    }

    public void sendMail(MailInfo mailInfo) {
        MailTemplate template = templates.get(mailInfo.getMailCode());
        if (template == null) {
            throw new IllegalArgumentException("No template for code: " + mailInfo.getMailCode());
        }

        String text = template.generateText(mailInfo);
        String receiver = mailInfo.getClient().getName().toLowerCase() + "@gmail.com";
        emailSender.send(receiver, text);
    }
}
