package com.yurets_y.spring_tutor_001.ch8_jpa.auditable;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareBean implements AuditorAware<String> {
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Yuriy_yakhnitsa");
    }
}
