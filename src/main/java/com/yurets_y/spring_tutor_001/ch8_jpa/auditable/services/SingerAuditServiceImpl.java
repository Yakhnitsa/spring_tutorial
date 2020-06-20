package com.yurets_y.spring_tutor_001.ch8_jpa.auditable.services;

import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.SingerAudit;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.repos.SingerAuditRepository;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {

    @Autowired
    private SingerAuditRepository singerAuditRepository;

    @Transactional(readOnly=true)
    public List<SingerAudit> findAll() {
        return Lists.newArrayList(singerAuditRepository.findAll());
    }

    /**
     * API  changed in  2.0.0.M3 findOne became findById
     * @param id
     * @return
     */
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).get();
    }

    public SingerAudit save(SingerAudit singer) {
        return singerAuditRepository.save(singer);
    }
}
