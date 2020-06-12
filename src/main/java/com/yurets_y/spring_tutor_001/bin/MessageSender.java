package com.yurets_y.spring_tutor_001.bin;

public interface MessageSender {

    void sendMessage();

    void setMessageProvider(MessageProvider messageProvider);
}
