package com.app.community.domain.member;

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
}
