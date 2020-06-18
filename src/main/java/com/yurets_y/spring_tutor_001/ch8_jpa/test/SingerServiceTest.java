package com.yurets_y.spring_tutor_001.ch8_jpa.test;

import com.yurets_y.spring_tutor_001.ch8_jpa.config.DataJpaConfig;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Album;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;
import com.yurets_y.spring_tutor_001.ch8_jpa.service.SingerService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SingerServiceTest {
    private SingerService singerService;
    private static Logger logger = LoggerFactory.getLogger(SingerServiceTest.class);
    private GenericApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        singerService = ctx.getBean("jpaSingerService", SingerService.class);
        assertNotNull(singerService);
    }


    @Test
    public void selectAllTest(){
        List<Singer> singerList = singerService.findAll();
        singerList.forEach(System.out::println);
    }

    @Test
    public void tesFindByCriteriaQuery() {
        List<Singer> singers = singerService.findByCriteriaQuery("John", "Mayer");
        assertEquals(1, singers.size());
        listSingersWithAlbum(singers);
    }
    @Test
    public void testFindByAlbumPeriod() {
        Date dateFrom = new GregorianCalendar(2000,1,1).getTime();
        Date dateUntil = new GregorianCalendar(2020,1,1).getTime();
        List<Album> singers = singerService.findByAlbumPeriod(dateFrom,dateUntil);
        System.out.println(singers);
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
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
