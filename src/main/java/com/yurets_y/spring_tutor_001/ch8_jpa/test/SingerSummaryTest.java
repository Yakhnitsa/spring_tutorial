package com.yurets_y.spring_tutor_001.ch8_jpa.test;

import com.yurets_y.spring_tutor_001.ch8_jpa.config.DataJpaConfig;
import com.yurets_y.spring_tutor_001.ch8_jpa.dto.SingerSummary;
import com.yurets_y.spring_tutor_001.ch8_jpa.service.SingerSummaryService;
import com.yurets_y.spring_tutor_001.ch8_jpa.service.SingerSummaryUntypeImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class SingerSummaryTest {
    @Test
    public void showSummaryTest(){
        GenericApplicationContext context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        SingerSummaryUntypeImpl summaryUntype = context.getBean(SingerSummaryUntypeImpl.class);

        summaryUntype.displayAllSingerSummary();
    }

    @Test
    public void singerSummaryTypedTest(){
        GenericApplicationContext context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        SingerSummaryService service = context.getBean(SingerSummaryService.class);
        List<SingerSummary> summaryList = service.findAll();
        summaryList.forEach(System.out::println);
    }
}
