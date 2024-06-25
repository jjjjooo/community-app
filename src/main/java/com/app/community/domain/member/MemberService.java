package com.app.community.domain.member;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberReader memberReader;
    private final MemberAppender memberAppender;

    /**
     * 온보딩 / 회원 정보 입력
     */
    public void onboard(
            @NotNull Long memberId,
            @NotNull String nickname,
            @NotNull Member.MemberPosition memberPosition
    ) {
        Member member = memberReader.getById(memberId);
        memberAppender.onboard(member, nickname, memberPosition);
    }

    /** 회원 세팅 정보 수정 */
    public void onboard(
        @NotNull Long memberId,
        @NotNull Boolean chatRefusal,
        @NotNull Integer chatPeePoint
    ){
        Member member = memberReader.getById(memberId);
        memberAppender.updateSettings(member, chatRefusal, chatPeePoint);
    }

    /** 회원 정보 조회 */
    public Member getMemberInfo(@NotNull Long memberId){
        return memberReader.getById(memberId);

    }

    /** 회원 서비스 포인트 이력 조회 */
    /** 회원 활동 이력 조회  */
}
