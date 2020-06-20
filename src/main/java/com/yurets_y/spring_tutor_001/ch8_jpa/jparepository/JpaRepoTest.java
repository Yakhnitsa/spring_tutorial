package com.yurets_y.spring_tutor_001.ch8_jpa.jparepository;

import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;
import com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.config.RepoDataJpaConfig;
import com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.service.SingerService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JpaRepoTest {
    private ApplicationContext ctx;
    private SingerService service;
    private static Logger logger = LoggerFactory.getLogger(JpaRepoTest.class);

    @Before
    public void initService(){
        ctx = new AnnotationConfigApplicationContext(RepoDataJpaConfig.class);
        service = ctx.getBean("repoBasedSingerService",SingerService.class);

    }
    @Test
    public void findByFirstNameTest(){

    }
    @Test
    public void findAllTest(){
        List<Singer> singers = service.findAll();
        singers.forEach(System.out::println);
    }
    @Test
    public void findByAlbumReleaseTest() throws ParseException {
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
        Date until = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
        List<Singer> singers = service.findByAlbumDate(from,until);
        printAllWithAlbums(singers);
    }

    private void printAllWithAlbums(List<Singer> singers) {
        logger.info(" ---- Listing singers with instruments:");
        singers.forEach(s -> {
            logger.info(s.toString());
            if (s.getAlbums() != null) {
                s.getAlbums().forEach(a -> logger.info("\t" + a.toString()));
            }
            if (s.getInstruments() != null) {
                s.getInstruments().forEach(i -> logger.info("\tInstrument: " + i.getInstrumentId()));
            }
        });
    }


}
