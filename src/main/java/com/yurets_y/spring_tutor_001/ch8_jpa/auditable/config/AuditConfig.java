package com.yurets_y.spring_tutor_001.ch8_jpa.auditable.config;


import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.Creator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class AuditConfig {


    @Bean
    public AuditorAware<Creator> auditorAwareBean(){
        return new AuditorAware<Creator>() {
            @Override
            public Optional<Creator> getCurrentAuditor() {
                Creator creator = new Creator();
                creator.setId(1L);

                return Optional.of(creator);
            }
        };
    }
}
