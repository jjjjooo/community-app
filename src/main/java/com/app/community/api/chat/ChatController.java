package com.app.community.api.chat;

import com.app.community.domain.chat.Chat;
import com.app.community.domain.chat.ChatService;
import com.app.community.domain.member.AuthMember;
import com.app.community.support.annotataion.AuthenticationMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/chats")
@RestController
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/check/{respondentId}")
    public ResponseEntity<ChatResponse.CheckChatResponse> checkAvailableChat(
            @AuthenticationMember AuthMember authMember,
            @PathVariable(name = "respondentId") Long respondentId
    ) {
        Chat chat = chatService.requestChat(respondentId, authMember.getMemberId());
        return ResponseEntity.ok().body(new ChatResponse.CheckChatResponse(chat.getId(), chat.getIsEnd()));
    }
}
