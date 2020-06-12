package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.row_mapper;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RowMapperDemo {

    @Test
    public void testRowMapper(){
        ApplicationContext context = new AnnotationConfigApplicationContext(RowMapperDaoConfig.class);

        SingerDao singerDao = context.getBean(SingerDao.class);
        List<Singer> singerList = singerDao.findAll();
        singerList.forEach(System.out::println);
    }
}
