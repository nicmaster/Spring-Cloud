package com.nicmaster.troll.sink.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    private final String uuid = UUID.randomUUID().toString();

    public BaseEntity() {

    }

    public abstract Long getId();

    public String getUuid() {
        return uuid;
    }

    public Date getCreatedDate() {
        Date date = null;
        if (createdDate != null) {
            date = new Date(createdDate.getTime());
        }
        return date;

    }

}
