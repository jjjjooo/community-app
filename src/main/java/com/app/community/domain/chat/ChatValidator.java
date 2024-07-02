package com.app.community.domain.chat;

import com.app.community.domain.member.Member;
import com.app.community.support.error.CoreApiException;
import com.app.community.support.error.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ChatValidator {

    public void canCreateChat(Member respondent, Long requesterId){
        checkMyRequest(respondent.getId(), requesterId);
        if(respondent.isChatRefusal()) throw new CoreApiException(ErrorType.DEFAULT_ERROR);
    }

    public void isChatAvailable(Chat chat, Member respondent){
        if(chat.getIsEnd()) throw new CoreApiException(ErrorType.DEFAULT_ERROR); //TODO 채팅종료
        if(respondent.isChatRefusal()) throw new CoreApiException(ErrorType.DEFAULT_ERROR); //TODO 채팅거부
    }

    public void checkMyRequest(Long respondentId, Long requesterId){
        if(requesterId.equals(respondentId)) throw new CoreApiException(ErrorType.DEFAULT_ERROR);
    }
}
