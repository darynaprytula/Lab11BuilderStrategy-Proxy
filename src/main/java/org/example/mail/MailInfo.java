package org.example.mail;

import lombok.Data;

@Data
public class MailInfo {
    private final Client client;
    private final MailCode mailCode;

    public MailInfo(Client client, MailCode mailCode) {
        this.client = client;
        this.mailCode = mailCode;
    }
}
