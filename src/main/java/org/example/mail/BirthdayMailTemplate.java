package org.example.mail;

public class BirthdayMailTemplate implements MailTemplate {
    @Override
    public String generateText(MailInfo info) {
        return "Happy Birthday, " + info.getClient().getName() + "!";
    }
}
