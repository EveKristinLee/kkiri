package com.lets.kkiri.repository.chat;

import com.lets.kkiri.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<Message, String> {
}
