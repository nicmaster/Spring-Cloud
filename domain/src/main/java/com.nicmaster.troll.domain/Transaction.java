package com.nicmaster.troll.domain;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    private String transactionReference;
    private String clientName;
    private String clientAccount;
    private Date transactionDate;
    private String cCY;
}
