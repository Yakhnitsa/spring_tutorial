package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.named_parameter;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.JdbcSingerDao;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/*
* Пример использования именованых параметров при запросе
* */
public class NamedParameterDao extends JdbcSingerDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public String findNameById(Long id) {
        String sql = "SELECT first_name FROM singer WHERE id = :singerId";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("singerId",id);
        return jdbcTemplate.queryForObject(sql,namedParameters,String.class);
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
        DataSource dataSource = jdbcTemplate.getDataSource();
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.jdbcTemplate == null) {
            throw new BeanCreationException("Null JdbcTemplate on SingerDao");
        }
    }
}
