package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.row_mapper;

import com.yurets_y.spring_tutor_001.ch6_jdbc.CleanUp;
import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.common_config.EmbeddedDbConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@Import(EmbeddedDbConfig.class)
public class RowMapperDaoConfig {

    @Resource(name="dataSource")
    private DataSource dataSource;

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Bean
    public SingerDao singerDao() {
        RowMapperDao dao = new RowMapperDao();
        dao.setJdbcTemplate(this.jdbcTemplate);
        return dao;
    }

    @Bean(destroyMethod = "destroy")
    public CleanUp cleanUp() {
        return new CleanUp(this.jdbcTemplate);
    }
}
