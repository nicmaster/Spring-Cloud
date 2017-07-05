package com.nicmaster.troll.source.file.web.rest;

import com.nicmaster.troll.domain.Message;
import com.nicmaster.troll.source.file.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController("/message")
public class MessageController {
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private MessageService messageService;

    @Autowired
    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMessage(@RequestBody final Message message) {
        System.out.println("rest count trans ==== " + message.getTransactions().size() );
        messageService.sendMessage(message);
    }
}
