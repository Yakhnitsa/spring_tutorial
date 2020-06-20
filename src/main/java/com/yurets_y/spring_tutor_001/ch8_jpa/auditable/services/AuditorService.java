package com.yurets_y.spring_tutor_001.ch8_jpa.auditable.services;

import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.Creator;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.repos.CreatorRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditorService {
    @Autowired
    private CreatorRepository creatorRepository;

    public List<Creator> findAll(){
        return Lists.newArrayList(creatorRepository.findAll());
    }
}
