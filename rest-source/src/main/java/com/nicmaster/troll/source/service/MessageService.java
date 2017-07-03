package com.nicmaster.troll.source.service;

import com.nicmaster.troll.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
public class MessageService {

    @Autowired
    private Source source;

    public void sendMessage(final Message message) {
        source.output().send(MessageBuilder.withPayload(message).build());
    }
}
