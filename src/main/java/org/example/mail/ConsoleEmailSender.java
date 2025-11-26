package org.example.mail;

public class ConsoleEmailSender implements EmailSender {
    @Override
    public void send(String to, String text) {
        System.out.println("sending email to: " + to);
        System.out.println("content: " + text);
    }
}
