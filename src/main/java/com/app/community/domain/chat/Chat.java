package com.app.community.domain.chat;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Chat {

    private Long id;
    private Long respondentId;
    private Long requesterId;
    private Boolean isEnd;
    private LocalDateTime endDate;
    private List<ChatMessage> chatMessageList = new ArrayList<>();

    @Builder
    private Chat(
            @Nullable Long id,
            @NotNull Long respondentId,
            @NotNull Long requesterId,
            @NotNull Boolean isEnd,
            @NotNull LocalDateTime endDate
    ) {
        this.id = id;
        this.respondentId = respondentId;
        this.requesterId = requesterId;
        this.isEnd = isEnd;
        this.endDate = endDate;
    }

    public static Chat create(Long respondentId, Long requesterId) {
        return Chat.builder()
                .requesterId(requesterId)
                .respondentId(respondentId)
                .isEnd(false)
                .endDate(LocalDateTime.now().plusWeeks(1))
                .build();
    }

    public void addMessage(Long requesterId) {
        ChatMessage firstMessage = ChatMessage.first(requesterId, this);
        this.chatMessageList.add(firstMessage);
    }

    public void sendMessage(String message, Long senderId) {
        if(!this.respondentId.equals(senderId) && !this.requesterId.equals(senderId))
            throw new IllegalArgumentException("비정상적인 접근입니다.");
        this.chatMessageList.add(ChatMessage.send(senderId, message, this));
    }
}
