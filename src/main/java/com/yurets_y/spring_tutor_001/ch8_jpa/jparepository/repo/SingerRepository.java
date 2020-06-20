package com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.repo;

import java.util.Date;
import java.util.List;

import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SingerRepository extends CrudRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);

    /*
    * Выборка данных по параметру одного из полей
    * distinct - удаление дублирующихся значений
    * left join fetch - жадная загрузка поля s.albums, s.instruments
    * where ... between  - передача параметров запроса
    * @Param("dateFrom) - опционально, если Date dateFrom совпадает с :dateFrom можно не писать.
    * */
    @Query("select distinct s from Singer s " +
            "left join fetch s.albums a " +
            "left join fetch s.instruments i " +
            "where a.releaseDate between :dateFrom and :dateUntil")
    List<Singer> findByAlbumDate(@Param("dateFrom") Date dateFrom,@Param("dateUntil") Date dateUntil);
}
