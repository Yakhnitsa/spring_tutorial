package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.result_set_extructor;

import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Album;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingerWithDetailExtractor implements ResultSetExtractor<List<Singer>> {
    @Override
    public List<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Singer> map = new HashMap<>();
        Singer singer;
        while (rs.next()) {
            Long id = rs.getLong("id");
            singer = map.get(id);
            if (singer == null) {
                singer = new Singer();
                singer.setId(id);
                singer.setFirstName(rs.getString("first_name"));
                singer.setLastName(rs.getString("last_name"));
                singer.setBirthDate(rs.getDate("birth_date"));
                singer.setAlbums(new ArrayList<>());
                map.put(id, singer);
            }
            Long albumId = rs.getLong("album_id");
            if (albumId > 0) {
                Album album = new Album();
                album.setId(albumId);
                album.setSingerId(id);
                album.setTitle(rs.getString("title"));
                album.setReleaseDate(rs.getDate("release_date"));
                singer.addAbum(album);
            }
        }
        return new ArrayList<>(map.values());
    }

}
