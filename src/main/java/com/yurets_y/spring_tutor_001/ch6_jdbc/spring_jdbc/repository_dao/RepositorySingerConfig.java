package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.repository_dao;


import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.common_config.EmbeddedDbConfig;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.result_set_extructor.SingerWithDetailExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlFunction;
import org.springframework.jdbc.object.SqlUpdate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@Import({EmbeddedDbConfig.class})
@ComponentScan(basePackages = "com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.repository_dao")
public class RepositorySingerConfig {

    @Resource(name="dataSource")
    DataSource dataSource;

    @Resource(name="select_all_singers")
    MappingSqlQuery<Singer> singerMappingSqlQuery;

    @Resource(name="select_by_first_name")
    MappingSqlQuery<Singer> selectByFirstName;


    @Resource(name="update_singer")
    SqlUpdate updateSinger;

    @Resource(name="insert_singer")
    SqlUpdate insertSinger;

    @Resource(name="insert_singer_album")
    BatchSqlUpdate insertSingerAlbum;

    @Bean("configured_singer_dao")
    SingerDao singerDao(){
        RepositorySingerDao singerDao = new RepositorySingerDao();
        singerDao.setDataSource(dataSource);
        singerDao.setSelectByFirstName(selectByFirstName);
        singerDao.setSingerMappingSqlQuery(singerMappingSqlQuery);
        singerDao.setUpdateSinger(updateSinger);
        singerDao.setInsertSinger(insertSinger);
        singerDao.setInsertSingerAlbum(insertSingerAlbum);
        singerDao.setSingerWithDetailExtractor(singerWithDetailExtractor());
        singerDao.setStoredFunctionFirstNameById(storedFunctionFirstNameById());

        return singerDao;
    }

    @Bean("storedFunctionFirstNameById")
    SqlFunction storedFunctionFirstNameById(){
        return new StoredFunctionFirstNameById(dataSource);
    }


    @Bean
    ResultSetExtractor<List<Singer>> singerWithDetailExtractor(){
        return new SingerWithDetailExtractor();
    }



}
