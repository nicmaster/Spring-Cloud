package com.nicmaster.troll.sink.service;

import com.nicmaster.troll.domain.Message;
import com.nicmaster.troll.domain.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MessageServiceIntegrationTest {

    @Autowired
    private MessageService messageService;

    @Test
    @Transactional
    public void when_persistMessage_expect_successful() {
        messageService.saveEvent(testMessage());
    }

    public Message testMessage() {
        Date date = new Date();
        Transaction transaction = new Transaction("77788ddd","dsdsd","dfdfdfd", date,"ok");
        List<Transaction> transactionList = new ArrayList();
        transactionList.add(transaction);
        Message message = new Message("test","savings","ftp",transactionList);
        return message;
    }
}
