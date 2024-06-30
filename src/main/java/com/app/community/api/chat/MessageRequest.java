package com.app.community.api.chat;

import com.app.mulba.domain.chat.ChatInfo;
import com.app.mulba.domain.chat.ChatMessage;

import java.time.LocalDateTime;

public class MessageRequest {

    public record SendMessage (
            Long messageId,
            Long chatId,
            ChatInfo.Participant sender,
            String content,
            LocalDateTime createdAt,
            ChatMessage.MessageType messageType,
            Boolean isRead
    ){}

}
