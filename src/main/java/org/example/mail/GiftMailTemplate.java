package org.example.mail;

public class GiftMailTemplate implements MailTemplate {
    @Override
    public String generateText(MailInfo info) {
        return "Hello " + info.getClient().getName() + "! You received a gift!";
    }
}
