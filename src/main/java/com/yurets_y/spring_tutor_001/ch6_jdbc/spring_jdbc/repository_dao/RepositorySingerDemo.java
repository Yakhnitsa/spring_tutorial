package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.repository_dao;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Album;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.row_mapper.RowMapperDaoConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class RepositorySingerDemo {

    private SingerDao singerDao;
    private GenericApplicationContext context;

    @Before
    public void initContext(){
        this.context = new AnnotationConfigApplicationContext(RepositorySingerConfig.class);
        this.singerDao = context.getBean("configured_singer_dao",SingerDao.class);
    }
    @After
    public void closeContext(){
        this.context.close();
    }

    @Test
    public void testRowMapper(){
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositorySingerConfig.class);

        SingerDao singerDao = context.getBean("configured_singer_dao",SingerDao.class);

        List<Singer> singerList = singerDao.findAll();
        singerList.forEach(System.out::println);

        List<Singer> find =  singerDao.findByFirstName("John");
        find.forEach(System.out::println);

        Singer updatedSinger = find.get(0);
        System.out.println("updated record");
        System.out.println(updatedSinger);
        updatedSinger.setFirstName("Leonardo");
        updatedSinger.setLastName("Bruno");

        singerDao.update(updatedSinger);

        System.out.println(" after update");
        List<Singer> singers = singerDao.findAll();
        singers.forEach(System.out::println);
    }

    @Test
    public void insertSingerTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositorySingerConfig.class);
        SingerDao singerDao = context.getBean("configured_singer_dao",SingerDao.class);

        Singer singer = new Singer();
        singer.setFirstName("Met");
        singer.setLastName("Daemont");
        Date birthDate = new GregorianCalendar(1989,01,12).getTime();
        singer.setBirthDate(new java.sql.Date(birthDate.getTime()));

        singerDao.insert(singer);

        List<Singer> singers = singerDao.findAll();
        singers.forEach(System.out::println);
    }

    @Test
    public void insertAlbumsTest(){
        Singer singer = new Singer();
        singer.setFirstName("Noize");
        singer.setLastName("MC");
        Date birthDate = new GregorianCalendar(1989,01,12).getTime();
        singer.setBirthDate(new java.sql.Date(birthDate.getTime()));
        singer.setAlbums(new ArrayList<>());

        Album album = new Album();
        album.setTitle("Behind the wall");
        Date release = new GregorianCalendar(2013,01,11).getTime();
        album.setReleaseDate(new java.sql.Date(release.getTime()));

        singer.getAlbums().add(album);

        ApplicationContext context = new AnnotationConfigApplicationContext(RepositorySingerConfig.class);
        SingerDao singerDao = context.getBean("configured_singer_dao",SingerDao.class);
        singerDao.insertWithAlbum(singer);

        List<Singer> singers = singerDao.findAllWithAlbums();
        singers.forEach(singer1 -> {
            System.out.println(singer1);
            if(singer1.getAlbums() != null){
                singer1.getAlbums().forEach(album1 -> System.out.println("---->" + album1));
            }
        });
    }


    @Test
    public void getNameByIdTest(){
        String firstName = singerDao.findFirstNameById(2L);
        System.out.println(firstName);
    }
}
