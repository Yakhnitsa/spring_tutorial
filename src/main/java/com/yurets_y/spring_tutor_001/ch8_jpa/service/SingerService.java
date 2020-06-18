package com.yurets_y.spring_tutor_001.ch8_jpa.service;




import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Album;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;

import java.util.Date;
import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
    List<Singer> findAllByNativeQuery();
    List<Singer> findByCriteriaQuery(String firstName, String lastName);
    List<Album> findByAlbumPeriod(Date from, Date until);
}
