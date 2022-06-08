package com.ironhack.lahonradezserver.repository;

import com.ironhack.lahonradezserver.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
