package com.yurets_y.spring_tutor_001.annotation;

import com.yurets_y.spring_tutor_001.bin.MessageProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("urkMessageProvider")
public class UkrainianMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Здоров браття!";
    }
}
