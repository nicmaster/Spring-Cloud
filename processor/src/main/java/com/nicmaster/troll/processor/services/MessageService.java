package com.nicmaster.troll.processor.services;

import java.io.IOException;

import com.nicmaster.troll.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Processor.class)
public class MessageService {
    private Processor processor;
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Message filter(final Message message) throws IOException {
        return message;
    }
}
