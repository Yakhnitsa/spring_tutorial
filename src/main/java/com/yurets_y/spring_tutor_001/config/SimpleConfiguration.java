package com.yurets_y.spring_tutor_001.config;

import com.yurets_y.spring_tutor_001.bin.MessageProvider;
import com.yurets_y.spring_tutor_001.bin.MessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfiguration {

    @Bean
    public MessageProvider provider(){
        return new MessageProvider() {
            public String getMessage() {
                return "Hello people";
            }
        };
    }

    @Bean
    public MessageSender sender(){
        MessageSender sender = new MessageSender() {
            MessageProvider messageProvider;
            public void sendMessage() {
                System.out.println(messageProvider.getMessage());
            }

            public void setMessageProvider(MessageProvider messageProvider) {
                this.messageProvider= messageProvider;
            }
        };
        sender.setMessageProvider(provider());

        return sender;
    }
}
