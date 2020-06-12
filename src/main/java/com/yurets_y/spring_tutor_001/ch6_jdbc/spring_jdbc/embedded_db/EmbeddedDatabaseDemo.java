package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.embedded_db;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.embedded_db.EmbeddedJdbcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class EmbeddedDatabaseDemo {
    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);

        System.out.println("First name for singer id 1 is: " +
                singerDao.findFirstNameById(1l));

        ctx.close();
    }
}
