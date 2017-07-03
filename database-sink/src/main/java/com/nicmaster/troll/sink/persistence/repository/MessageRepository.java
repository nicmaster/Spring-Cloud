package com.nicmaster.troll.sink.persistence.repository;


import com.nicmaster.troll.sink.persistence.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long>, RevisionRepository<MessageEntity, Long, Integer> {
}
