package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.embedded_db;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.JdbcSingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.CleanUp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/*
 * Конфигурация с использованием встроенной базы данных
 * При создании добавляются 2 скрипта: schema.sql - для построения базы данных, и test-data.sql для создания тестовых записей
 * */
@Configuration
public class EmbeddedJdbcConfig {

    private static Logger logger = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);

    /*
    * Создание встроенной базы данных
    */
    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            // Создание встроенной базы данных по типу H2
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts(
                            "classpath:spring/ch6_jdbc/embedded_db/schema.sql",
                            "classpath:spring/ch6_jdbc/embedded_db/test-data.sql",
                            "classpath:spring/ch6_jdbc/embedded_db/stored-function.sql" //Сохранение функции в базе данных

                            )
                    .build();
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public SingerDao singerDao() {
        JdbcSingerDao dao = new JdbcSingerDao();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }

    @Bean(destroyMethod = "destroy")
    public CleanUp cleanUp() {
        return new CleanUp(jdbcTemplate());
    }
}
