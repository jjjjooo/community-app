package com.app.community.domain.chat;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class ChatMessage {

    private @Nullable Long id;
    private @NotNull Long chatId;
    private @NotNull Long senderId;
    private @Nullable String content;
    private @NotNull Boolean isRead;
    private @NotNull MessageType messageType;

    @Builder
    private ChatMessage(
            @Nullable Long id,
            @NotNull Long chatId,
            @NotNull Long senderId,
            @Nullable String content,
            @NotNull Boolean isRead,
            @NotNull MessageType messageType
    ) {
        this.id = id;
        this.chatId = chatId;
        this.senderId = senderId;
        this.content = content;
        this.isRead = isRead;
        this.messageType = messageType;
    }

    public static ChatMessage first(Long requesterId, Chat chat) {
        return ChatMessage.builder()
                .senderId(requesterId)
                .messageType(MessageType.MESSAGE)
                .isRead(false)
                .build();
    }

    public static ChatMessage send(Long senderId, String content, Chat chat) {
        return ChatMessage.builder()
                .chatId(chat.getId())
                .senderId(senderId)
                .messageType(MessageType.MESSAGE)
                .content(content)
                .isRead(false)
                .build();
    }

    public enum MessageType {
        MESSAGE;
    }
}
