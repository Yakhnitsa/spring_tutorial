package com.yurets_y.spring_tutor_001.message_sourse_and_internalization;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceExample {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-message-source.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, german));

        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John",
                "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John",
                "Mayer"}, german));

        ctx.close();
    }
}
