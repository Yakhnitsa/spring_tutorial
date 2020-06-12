package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.result_set_extructor;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.row_mapper.RowMapperDaoConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ResultSetExtructorDemo {

    @Test
    public void testRowMapper(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ResultSetExtructorConfig.class);

        SingerDao singerDao = context.getBean(SingerDao.class);
        List<Singer> singerList = singerDao.findAllWithAlbums();
        singerList.forEach(singer -> {
            System.out.println(singer);
            singer.getAlbums().forEach(album -> System.out.println("     " + album));
        });
    }
}
