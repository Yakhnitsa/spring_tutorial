package com.yurets_y.spring_tutor_001.ch8_jpa.service;


import com.yurets_y.spring_tutor_001.ch8_jpa.dto.SingerSummary;

import java.util.List;

public interface SingerSummaryService {
    List<SingerSummary> findAll();
}
