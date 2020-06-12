package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.common_config;

import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.named_parameter.NamedParameterJdbcConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class EmbeddedDbConfig {

    private static Logger logger = LoggerFactory.getLogger(NamedParameterJdbcConfig.class);

    /*
     * Создание встроенной базы данных
     */
    /*
     * Создание встроенной базы данных
     */
    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts(
                            // Создание схемы
                            "classpath:spring/ch6_jdbc/embedded_db/schema.sql",
                            // Создание тестовых значений
                            "classpath:spring/ch6_jdbc/embedded_db/test-data.sql",
                            //Сохранение встроенной функции в базе данных
                            "classpath:spring/ch6_jdbc/embedded_db/stored-function.sql"
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
}
