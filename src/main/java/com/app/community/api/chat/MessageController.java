package com.app.community.api.chat;

import com.app.mulba.domain.chat.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(MessageRequest.SendMessage request) {
        chatService.saveMessage(request.content(), request.chatId(), request.sender().memberId());
        messagingTemplate.convertAndSend("/topic/chat/" + request.chatId(), request);
    }
}
