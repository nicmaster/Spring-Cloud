package com.nicmaster.troll.sink.binding;

import com.nicmaster.troll.domain.Message;
import com.nicmaster.troll.sink.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageSink {
    private static Logger logger = LoggerFactory.getLogger(MessageSink.class);

    @Autowired
    private MessageService eventService;

    @StreamListener(Sink.INPUT)
    public void sinkMessage(final Message message) {
        eventService.saveEvent(message);
    }
}
