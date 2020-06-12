package com.yurets_y.spring_tutor_001.ch6_jdbc.spring_jdbc.repository_dao;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Album;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlFunction;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository()
public class RepositorySingerDao implements SingerDao {

    private DataSource dataSource;

    private MappingSqlQuery<Singer> singerMappingSqlQuery;

    private MappingSqlQuery<Singer> selectByFirstName;

    private SqlUpdate updateSinger;

    private SqlUpdate insertSinger;

    private BatchSqlUpdate insertSingerAlbum;

    private ResultSetExtractor<List<Singer>> singerWithDetailExtractor;

    private SqlFunction storedFunctionFirstNameById;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Singer> findAll() {
        return singerMappingSqlQuery.execute();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        Map<String, Object> paramМap = new HashMap<>();
        paramМap.put("first_name", firstName);
        return selectByFirstName.executeByNamedParam(paramМap);
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    // Вызов встроенной функции для получения данных
    @Override
    public String findFirstNameById(Long id) {
        List<String> result = storedFunctionFirstNameById.execute(id);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> paramМap = new HashMap<>();
        paramМap.put("first_name", singer.getFirstName());
        paramМap.put("last_name", singer.getLastName());
        paramМap.put("birth_date", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramМap, keyHolder);
        singer.setId(keyHolder.getKey().longValue() );
    }

    @Override
    public void update(Singer singer) {
        Map<String, Object> paramМap =
                new HashMap<String, Object>();
        paramМap.put("first_name", singer.getFirstName());
        paramМap.put("last_name", singer.getLastName());
        paramМap.put("birth_date", singer.getBirthDate() );
        paramМap.put("id", singer.getId());
        updateSinger.updateByNamedParam(paramМap);
    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public List<Singer> findAllWithAlbums() {
        JdbcTemplate template = new JdbcTemplate(getDataSource());
        String sql = "SELECT s.id, s.first_name, s.last_name, s.birth_date" +
                ", a.id AS album_id, a.title, a.release_date FROM singer s " +
                "LEFT JOIN album a on s.id = a.singer_id";
        return template.query(sql, singerWithDetailExtractor);
    }

    @Override
    public void insertWithAlbum(Singer singer) {
//        !!! ВАЖНО. Класс BatchSqlUpdate не является потокобезопасным.
//        Для обеспечения потокобезопасности при каждой вставке создается новая ссылка на экземпляр
        insertSingerAlbum = new InsertSingerAlbum(dataSource);

        Map<String, Object> paramМap = new HashMap<>();
        paramМap.put("first_name", singer.getFirstName());
        paramМap.put("last_name", singer.getLastName());
        paramМap.put("birth_date", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramМap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());

        List<Album> albums = singer.getAlbums();
        if(albums != null){
            for(Album album: albums){
                paramМap = new HashMap<>();
                paramМap.put("singer_id",singer.getId());
                paramМap.put("title",album.getTitle());
                paramМap.put("release_date",album.getReleaseDate());

                insertSingerAlbum.updateByNamedParam(paramМap);
            }
        }
        insertSingerAlbum.flush();
    }


    public void setSingerMappingSqlQuery(MappingSqlQuery<Singer> singerMappingSqlQuery) {
        this.singerMappingSqlQuery = singerMappingSqlQuery;
    }


    public void setSelectByFirstName(MappingSqlQuery<Singer> selectByFirstName) {
        this.selectByFirstName = selectByFirstName;
    }

    public void setUpdateSinger(SqlUpdate updateSinger) {
        this.updateSinger = updateSinger;
    }

    public void setInsertSinger(SqlUpdate insertSinger) {
        this.insertSinger = insertSinger;
    }

    public void setInsertSingerAlbum(BatchSqlUpdate insertSingerAlbum) {
        this.insertSingerAlbum = insertSingerAlbum;
    }

    public void setSingerWithDetailExtractor(ResultSetExtractor<List<Singer>> singerWithDetailExtractor) {
        this.singerWithDetailExtractor = singerWithDetailExtractor;
    }

    public void setStoredFunctionFirstNameById(SqlFunction storedFunctionFirstNameById) {
        this.storedFunctionFirstNameById = storedFunctionFirstNameById;
    }
}
