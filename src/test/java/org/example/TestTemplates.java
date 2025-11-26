package org.example;

import org.example.mail.BirthdayMailTemplate;
import org.example.mail.GiftMailTemplate;
import org.example.mail.MailCode;
import org.example.mail.MailTemplate;

import java.util.Map;

public class TestTemplates {
    public static Map<MailCode, MailTemplate> defaultTemplates() {
        return Map.of(
            MailCode.GIFT, new GiftMailTemplate(),
            MailCode.BIRTHDAY, new BirthdayMailTemplate()
        );
    }
}
