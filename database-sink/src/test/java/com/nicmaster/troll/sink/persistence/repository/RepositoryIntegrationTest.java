package com.nicmaster.troll.sink.persistence.repository;
import com.nicmaster.troll.sink.persistence.entity.MessageEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RepositoryIntegrationTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    @Transactional
    @Rollback
    public void when_persistingEventEntity_expect_dataPersisted() {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setApplicationName("test");
        messageEntity.setTransactionType("Savings");
        messageEntity.setMessageType("HTTP");
        messageRepository.save(messageEntity);
        MessageEntity returnEntity = messageRepository.findAll().get(0);

        assertNotNull("Event entity uuId generated", returnEntity.getUuid());
    }
}
