package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.result_set_extructor;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.JdbcSingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Album;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetExtructorDao extends JdbcSingerDao {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
        DataSource dataSource = jdbcTemplate.getDataSource();
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        if (this.jdbcTemplate == null) {
            throw new BeanCreationException("Null JdbcTemplate on SingerDao");
        }
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        String sql = "SELECT s.id, s.first_name, s.last_name, s.birth_date" +
                ", a.id AS album_id, a.title, a.release_date FROM singer s " +
                "LEFT JOIN album a on s.id = a.singer_id";
        return jdbcTemplate.query(sql,new SingerWithDetailExtractor() );
    }
}
