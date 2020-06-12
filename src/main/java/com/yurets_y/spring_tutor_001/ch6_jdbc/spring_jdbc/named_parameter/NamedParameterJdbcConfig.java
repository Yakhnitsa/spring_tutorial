package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.named_parameter;

import com.yurets_y.spring_tutor_001.ch6_jdbc.CleanUp;
import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.JdbcSingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.common_config.EmbeddedDbConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.annotation.Resource;
import javax.sql.DataSource;

/*
 * Конфигурация с использованием встроенной базы данных
 * При создании добавляются 2 скрипта: schema.sql - для построения базы данных, и test-data.sql для создания тестовых записей
 * */
@Configuration
@Import(EmbeddedDbConfig.class)
public class NamedParameterJdbcConfig {

    private static Logger logger = LoggerFactory.getLogger(NamedParameterJdbcConfig.class);

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Bean
    public SingerDao singerDao() {
        NamedParameterDao dao = new NamedParameterDao();
        dao.setJdbcTemplate(this.jdbcTemplate);
        return dao;
    }

    @Bean(destroyMethod = "destroy")
    public CleanUp cleanUp() {
        return new CleanUp(this.jdbcTemplate);
    }
}
