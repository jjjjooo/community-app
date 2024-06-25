package com.app.community.domain.member;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * 회원[Member] 클래스의 변경 및새성을 담당하는 구현체
 */
@RequiredArgsConstructor
@Component
public class MemberAppender {

    private final MemberRepository memberRepository;

    public Member append(@NotNull String socialId, @NotNull String socialProvider) {
        return Member.registerBySocial(socialId, socialProvider);
    }

    public void onboard(Member member, String nickname, Member.MemberPosition memberPosition) {
        member.onboard(nickname, memberPosition);
        memberRepository.save(member);
    }

    public void updateSettings(Member member, Boolean chatRefusal, Integer chatPeePoint) {
        member.updateSettings(chatRefusal, chatPeePoint);
        memberRepository.save(member);
    }
}
