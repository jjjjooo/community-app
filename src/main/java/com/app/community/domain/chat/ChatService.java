package com.app.community.domain.chat;

import com.app.community.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final MemberReader memberReader;
    private final ChatAppender chatAppender;
    private final ChatReader chatReader;
    private final ChatValidator chatValidator;

    public Chat requestChat(Long respondentId, Long requesterId){
        var respondent = memberReader.getById(respondentId);
        chatValidator.isChatAvailable(respondent, requesterId);
        var chatOp = chatReader.findByParticipantsId(respondentId, requesterId);
        return chatOp.orElseGet(() -> chatAppender.create(respondentId, requesterId));
    }

    @Transactional
    public void saveMessage(String message, Long chatId, Long senderId){
        Chat chat = chatReader.getById(chatId);
        chat.sendMessage(message, senderId);
    }
}
