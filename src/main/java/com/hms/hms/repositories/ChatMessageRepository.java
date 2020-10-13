package com.hms.hms.repositories;

import com.hms.hms.models.MessageModel;
import com.hms.hms.models.MessageStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository
        extends MongoRepository<MessageModel, String>{

    long countBySenderIdAndRecipientIdAndStatus(
            String senderId, String recipientId, MessageStatus status);

    List<MessageModel> findByChatId(String chatId);
}
