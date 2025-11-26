package org.example.mail;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MailBox {
    private final MailSender mailSender;
    private final List<MailInfo> infos = new ArrayList<>();

    public MailBox(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }

    public void sendAll() {
        for (MailInfo info : infos) {
            mailSender.sendMail(info);
        }
        infos.clear();
    }
}
