package com.app.community.domain.member;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

/** 회원의 인증을 담당 */
@RequiredArgsConstructor
@Service
public class AuthMemberService {

    private final MemberReader memberReader;
    private final MemberAppender memberAppender;

    public Member authentication(
            @NotNull String socialId,
            @NotNull String socialProvider
    ){
        Optional<Member> memberOp = memberReader.findBySocial(socialId, socialProvider);
        return memberOp.orElseGet(() -> memberAppender.append(socialId, socialProvider));
    }
}
