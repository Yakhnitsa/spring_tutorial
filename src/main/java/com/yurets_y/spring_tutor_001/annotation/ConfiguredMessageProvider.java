package com.yurets_y.spring_tutor_001.annotation;

import com.yurets_y.spring_tutor_001.bin.MessageProvider;
import org.springframework.stereotype.Component;

@Component("confMessageProvider")
public class ConfiguredMessageProvider implements MessageProvider {
    private String message;

    public ConfiguredMessageProvider() {
    }

    public ConfiguredMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
