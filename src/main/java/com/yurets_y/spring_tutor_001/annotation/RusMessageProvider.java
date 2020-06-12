package com.yurets_y.spring_tutor_001.annotation;

import com.yurets_y.spring_tutor_001.bin.MessageProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("rusMessageProvider")
public class RusMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Здравствуй быдло";
    }
}
