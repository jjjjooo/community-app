package com.app.community.domain.chat;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageAppender {

    private final MessageRepository messageRepository;

    public void append(String content, Chat chat, Long senderId) {
        Message message = Message.send(senderId, content, chat.getId());
        messageRepository.save(message);
    }
}
