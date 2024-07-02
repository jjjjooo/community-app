package com.app.community.storage.chat;

import com.app.community.storage.AbstractEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "chat_messages")
@Entity
public class MessageEntity extends AbstractEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long senderId;
    private String content;
    private Boolean isRead;
    @Enumerated(EnumType.STRING)
    private MessageType messageType;
    public enum MessageType {
        MESSAGE, IMAGE, JOIN;
    }
}
