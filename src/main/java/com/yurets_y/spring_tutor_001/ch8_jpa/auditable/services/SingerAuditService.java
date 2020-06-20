package com.yurets_y.spring_tutor_001.ch8_jpa.auditable.services;


import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.SingerAudit;

import java.util.List;

public interface SingerAuditService {
    List<SingerAudit> findAll();
    SingerAudit findById(Long id);
    SingerAudit save(SingerAudit singer);
}
