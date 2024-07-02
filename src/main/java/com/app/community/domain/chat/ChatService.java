package com.app.community.domain.chat;

import com.app.community.domain.member.Member;
import com.app.community.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final MemberReader memberReader;
    private final ChatAppender chatAppender;
    private final ChatReader chatReader;
    private final ChatValidator chatValidator;
    private final MessageAppender messageAppender;

    public Chat requestChat(Long respondentId, Long requesterId){
        Member respondent = memberReader.getById(respondentId);
        chatValidator.canCreateChat(respondent, requesterId);
        Optional<Chat> chatOp = chatReader.findByParticipantsId(respondentId, requesterId);
        return chatOp.orElseGet(() -> chatAppender.create(respondentId, requesterId));
    }

    public void saveMessage(String message, Long chatId, Long senderId){
        Chat chat = chatReader.getById(chatId);
        Member respondent = memberReader.getRespondent(chat);
        chatValidator.isChatAvailable(chat, respondent);
        messageAppender.append(message, chat, senderId);
    }
}
