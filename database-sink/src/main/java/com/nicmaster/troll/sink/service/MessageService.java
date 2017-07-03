package com.nicmaster.troll.sink.service;

import com.nicmaster.troll.domain.Message;
import com.nicmaster.troll.domain.Transaction;
import com.nicmaster.troll.sink.persistence.entity.MessageEntity;
import com.nicmaster.troll.sink.persistence.entity.TransactionEntity;
import com.nicmaster.troll.sink.persistence.repository.MessageRepository;
import com.nicmaster.troll.sink.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public MessageService(final MessageRepository messageRepository, final TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.messageRepository = messageRepository;
    }

    @Transactional
    public void saveEvent(final Message message) {
        List<TransactionEntity> transactionList = new ArrayList<>();
        MessageEntity messageEntity = new MessageEntity(message.getApplicationName(),message.getTransactionType(), message.getMessageType());

        for (Transaction trans : message.getTransactions()) {
            TransactionEntity transactions = transactionEntityQuery(trans.getTransactionReference());

            if (transactions != null) {
                transactionList.add(transactions);
            } else {
                transactionList.add(new TransactionEntity(trans.getTransactionReference(),
                        trans.getClientName(),trans.getClientAccount(), trans.getTransactionDate(),trans.getCCY()));
            }
        }
        messageEntity.setTransactions(transactionList);
        MessageEntity re = messageRepository.save(messageEntity);

    }

    public TransactionEntity transactionEntityQuery(final String transactionReference) {
        TransactionEntity transactionEntity = transactionRepository.findByTransactionReference(transactionReference);
        return transactionEntity;
    }

}
