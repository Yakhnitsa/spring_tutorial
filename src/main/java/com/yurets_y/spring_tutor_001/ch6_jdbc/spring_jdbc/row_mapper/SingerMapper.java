package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.row_mapper;

import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SingerMapper implements RowMapper<Singer> {
    @Override
    public Singer mapRow(ResultSet resultSet, int i) throws SQLException {
        Singer singer = new Singer();
        singer.setId(resultSet.getLong("id"));
        singer.setFirstName(resultSet.getString("first_name"));
        singer.setLastName(resultSet.getString("last_name"));
        singer.setBirthDate(resultSet.getDate("birth_date"));
        return singer;
    }
}
