package com.yurets_y.spring_tutor_001.annotation;

import com.yurets_y.spring_tutor_001.bin.MessageProvider;
import com.yurets_y.spring_tutor_001.bin.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("faxMessageSender")
public class FaxMessageSender implements MessageSender {
    private MessageProvider messageProvider;
    @Override
    public void sendMessage() {
        System.out.println("Sending message by fax....");
        System.out.println(messageProvider.getMessage());
        System.out.println("Error... fax is to old technology");
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
