package com.yurets_y.spring_tutor_001.ch8_jpa.auditable.repos;

import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.SingerAudit;
import org.springframework.data.repository.CrudRepository;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
