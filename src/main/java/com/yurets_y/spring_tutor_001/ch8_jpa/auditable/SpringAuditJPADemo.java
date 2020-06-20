package com.yurets_y.spring_tutor_001.ch8_jpa.auditable;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;


import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.config.BasicConfig;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.Creator;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.SingerAudit;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.services.AuditorService;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.services.SingerAuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringAuditJPADemo {
    private static Logger logger = LoggerFactory.getLogger(SpringAuditJPADemo.class);

    public static void main(String... args) {

        //GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/app-context-annotation.xml");
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(BasicConfig.class);

        SingerAuditService singerAuditService = ctx.getBean(SingerAuditService.class);

        List<SingerAudit> singers = singerAuditService.findAll();
        listSingers(singers);

        System.out.println("Add new singer");
        SingerAudit singer = new SingerAudit();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, 8, 16)).getTime().getTime()));
        singerAuditService.save(singer);
        singers = singerAuditService.findAll();
        listSingers(singers);

        singer = singerAuditService.findById(4l);
        System.out.println("");
        System.out.println("Singer with id 1:" + singer);
        System.out.println("");

        System.out.println("Update singer");
        singer.setFirstName("Riley B.");
        singerAuditService.save(singer);
        singers = singerAuditService.findAll();
        listSingers(singers);

        AuditorService auditorService =ctx.getBean(AuditorService.class);

        List<Creator> creatorList = auditorService.findAll();

        ctx.close();
    }

    private static void listSingers(List<SingerAudit> singers) {
        logger.info(" ---- Listing singers:");
        singers.forEach(s -> logger.info(s.toString()));
    }
}
