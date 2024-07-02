package com.app.community.domain.member;

import com.app.community.domain.chat.Chat;
import com.app.community.support.error.CoreApiException;
import com.app.community.support.error.ErrorType;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 회원[Member] 클래스의 조회를 담당하는 구현체
 */
@RequiredArgsConstructor
@Component
public class MemberReader {

    private final MemberRepository memberRepository;

    public Optional<Member> findById(@NotNull Long memberId){
        return memberRepository.findById(memberId);
    }

    public Member getById(@NotNull Long memberId){
        return findById(memberId).orElseThrow();
    }

    public Optional<Member> findBySocial(@NotNull String socialId, @NotNull String socialProvider){
        return memberRepository.findBySocial(socialId, socialProvider);
    }

    public Member getRespondent(Chat chat) {
        return getById(chat.getRespondentId());
    }
}
