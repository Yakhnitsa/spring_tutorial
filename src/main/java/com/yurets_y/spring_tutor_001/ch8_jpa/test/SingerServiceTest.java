package com.yurets_y.spring_tutor_001.ch8_jpa.test;

import com.yurets_y.spring_tutor_001.ch8_jpa.config.DataJpaConfig;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;
import com.yurets_y.spring_tutor_001.ch8_jpa.service.SingerService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SingerServiceTest {
    private SingerService singerService;


    @Test
    public void selectAllTest(){
        GenericApplicationContext context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        singerService = context.getBean(SingerService.class);
        assertNotNull(singerService);
        List<Singer> singerList = singerService.findAll();
        singerList.forEach(System.out::println);
    }
}
