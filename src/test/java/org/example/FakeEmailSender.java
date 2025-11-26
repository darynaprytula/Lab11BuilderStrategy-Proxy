package org.example;

import org.example.mail.EmailSender;

public class FakeEmailSender implements EmailSender {
    public int count = 0;
    public String lastReceiver;
    public String lastText;

    @Override
    public void send(String receiver, String text) {
        count++;
        lastReceiver = receiver;
        lastText = text;
    }
}
