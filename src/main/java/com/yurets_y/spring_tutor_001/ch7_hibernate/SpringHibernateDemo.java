package com.yurets_y.spring_tutor_001.ch7_hibernate;


import com.yurets_y.spring_tutor_001.ch7_hibernate.config.HibernateConfig;
import com.yurets_y.spring_tutor_001.ch7_hibernate.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch7_hibernate.entities.Album;
import com.yurets_y.spring_tutor_001.ch7_hibernate.entities.Singer;
import org.hibernate.LazyInitializationException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SpringHibernateDemo {

    private SingerDao dao;

    private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    @Before
    public void initDao(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        this.dao = context.getBean("singerDao",SingerDao.class);
    }
    @Test
    public void findAllSingersClass(){

        List<Singer> singers = dao.findAll();
        singers.forEach(System.out::println);
    }

    @Test(expected = LazyInitializationException.class)
    /*Ожидается исключение при загрузке связанного содержимого
    Singer.albums - под ленивой загрузкой*/
    public void lazyInitExeptionTest(){
        List<Singer> singers =  dao.findAll();
        singers.forEach(singer -> {
            logger.info(singer.toString());
            if(singer.getAlbums() != null){
                singer.getAlbums().forEach(album -> logger.info("\t" + album.toString()));
            }
        });
    }

    @Test
    public void singerWithAlbumsTest(){
        List<Singer> singers =  dao.findAllWithAlbum();
        singers.forEach(singer -> {
            logger.info(singer.toString());
            if(singer.getAlbums() != null){
                singer.getAlbums().forEach(album -> logger.info("\t" + album.toString()));
            }
        });
    }

    @Test
    public void findByIdTest(){
        Singer singer = dao.findById(1L);
        logger.info(singer.toString());
        if(singer.getAlbums() != null){
            singer.getAlbums().forEach(album -> {
                logger.info("\t" + album.toString());
                logger.info("\t\t" + album.getTitle());
            });
        }
        if(singer.getInstruments() != null){
            singer.getInstruments().forEach(instrument -> {
                logger.info("\t" + instrument.toString());
            });
        }

    }

    @Test
    public void testInsert(){
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, 8, 16)).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        singer.addAbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
        singer.addAbum(album);

        dao.save(singer);
        assertNotNull(singer.getId());

        List<Singer> singers = dao.findAllWithAlbum();
        assertEquals(4, singers.size());
    }

    @Test
    public void testUpdate(){
        Singer singer = dao.findById(1L);
        //making sure such singer exists
        assertNotNull(singer);
        //making sure we got expected record
        assertEquals("Mayer", singer.getLastName());
        //retrieve the album
        Album album = singer.getAlbums().stream().filter(a -> a.getTitle().equals("Battle Studies")).findFirst().get();

        singer.setFirstName("John Clayton");
        singer.removeAlbum(album);
        dao.save(singer);

        listSingersWithAlbum(dao.findAllWithAlbum());
    }

    @Test
    public void testDelete(){
        Singer singer = dao.findById(2l);
        //making sure such singer exists
        assertNotNull(singer);
        dao.delete(singer);

        listSingersWithAlbum(dao.findAllWithAlbum());
    }

    @Test
    public void findAllAlbumsTest(){
        List<Album> albums = dao.findAllAlbums();
        albums.forEach(album -> {
            logger.info(album.toString());
            logger.info("\t" + album.getTitle());
        });
    }

    private static void listSingers(List<Singer> singers) {
        logger.info(" ---- Listing singers:");
        singers.forEach(singer -> logger.info(singer.toString()));
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info(" ---- Listing singers with instruments:");
        singers.forEach(singer -> {
            logger.info(singer.toString());
            if (singer.getAlbums() != null) {
                singer.getAlbums().forEach(album -> logger.info("\t" + album.toString()));
            }
            if (singer.getInstruments() != null) {
                singer.getInstruments().forEach(instrument -> instrument.getInstrumentId());
            }
        });
    }



}
