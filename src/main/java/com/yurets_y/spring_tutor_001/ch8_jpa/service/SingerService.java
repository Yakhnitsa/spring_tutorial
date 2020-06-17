package com.yurets_y.spring_tutor_001.ch8_jpa.service;




import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
    List<Singer> findAllByNativeQuery();
}
