package com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.service;


import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;

import java.util.Date;
import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
    List<Singer> findByAlbumDate(Date dateFrom, Date dateUntil);
}
