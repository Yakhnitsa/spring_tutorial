package com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.service;


import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;
import com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.repo.SingerRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("repoBasedSingerService")
@Transactional
public class SingerServiceRepoImpl implements SingerService {

    @Autowired
    public SingerServiceRepoImpl(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    private SingerRepository singerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findByFirstName(String firstName) {
        return singerRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return singerRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public List<Singer> findByAlbumDate(Date dateFrom, Date dateUntil) {
        return singerRepository.findByAlbumDate(dateFrom,dateUntil);
    }
}
