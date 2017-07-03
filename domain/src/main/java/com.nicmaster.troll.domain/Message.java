package com.nicmaster.troll.domain;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Message {
    private String applicationName;
    private String transactionType;
    private String messageType;
    protected List<Transaction> transactions;

}
