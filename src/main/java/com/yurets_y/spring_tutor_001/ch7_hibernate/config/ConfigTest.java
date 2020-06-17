package com.yurets_y.spring_tutor_001.ch7_hibernate.config;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.row_mapper.RowMapperDaoConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Properties;

public class ConfigTest {

    @Test
    public void configTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        Properties properties = context.getBean(Properties.class);

    }
}
