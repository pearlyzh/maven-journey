package com.nghiatn.maven.repository;

import com.nghiatn.maven.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nghiatn
 */

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
