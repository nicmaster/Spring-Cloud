package com.nicmaster.troll.sink.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = TransactionEntity.NAME,
        indexes = {@Index(name = TransactionEntity.NAME + "_uuid_idx", columnList = "uuid", unique = true)})
public class TransactionEntity extends BaseEntity {
    public static final String NAME = "transaction";
    private static final String SEQUENCE_NAME = NAME + "_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    @JsonIgnore
    private Long id;
    private String transactionReference;
    private String clientName;
    private String clientAccount;
    private Date transactionDate;
    private String cCY;

    public TransactionEntity() {

    }

    public TransactionEntity(String transactionReference, String clientName, String clientAccount, Date transactionDate, String cCY) {
        this.transactionReference = transactionReference;
        this.clientName = clientName;
        this.clientAccount = clientAccount;
        this.transactionDate = transactionDate;
        this.cCY = cCY;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(final String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(final String clientAccount) {
        this.clientAccount = clientAccount;
    }

    public Date getValueDate() {
        return transactionDate;
    }

    public void setValueDate(final Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getcCY() {
        return cCY;
    }

    public void setcCY(final String cCY) {
        this.cCY = cCY;
    }

}
