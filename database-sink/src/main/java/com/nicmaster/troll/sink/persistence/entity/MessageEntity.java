package com.nicmaster.troll.sink.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = MessageEntity.NAME,
        indexes = {@Index(name = MessageEntity.NAME + "_uuid_idx", columnList = "uuid", unique = true)})
public class MessageEntity extends BaseEntity {
    public static final String NAME = "message";
    private static final String SEQUENCE_NAME = NAME + "_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    @JsonIgnore
    private Long id;
    private String applicationName;
    private String transactionType;
    private String messageType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<TransactionEntity> transactions;

    public MessageEntity(String applicationName, String transactionType, String messageType) {
        this.applicationName = applicationName;
        this.transactionType = transactionType;
        this.messageType = messageType;
    }

    public MessageEntity(){

    }

    @Override
    public Long getId() {
        return id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(final String applicationName) {
        this.applicationName = applicationName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(final String transactionType) {
        this.transactionType = transactionType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Collection<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
}
