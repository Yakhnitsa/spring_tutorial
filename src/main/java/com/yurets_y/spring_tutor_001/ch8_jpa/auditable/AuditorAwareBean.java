package com.yurets_y.spring_tutor_001.ch8_jpa.auditable;

import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.Creator;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareBean implements AuditorAware<Creator> {
    public Optional<Creator> getCurrentAuditor() {
        Creator creator = new Creator();
        creator.setId(1L);

        return Optional.of(creator);
    }
}
