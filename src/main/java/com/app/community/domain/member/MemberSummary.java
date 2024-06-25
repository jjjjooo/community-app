package com.app.community.domain.member;

public class MemberSummary {

    public record MemberInfo(
            Long id,
            String socialId,
            String socialProvider,
            String email,
            String nickname,
            String profileImagePath,
            int point,
            int money,
            int chatPeePoint,
            boolean chatRefusal,
            Member.MemberPosition position,
            Member.MemberStatus status,
            Member.MemberGrade grade
    ) {
        public static MemberInfo of(Member member) {
            return new MemberInfo(
                    member.getId(),
                    member.getSocialId(),
                    member.getSocialProvider(),
                    member.getEmail(),
                    member.getNickname(),
                    member.getProfileImagePath(),
                    member.getPoint(),
                    member.getMoney(),
                    member.getChatPeePoint(),
                    member.isChatRefusal(),
                    member.getPosition(),
                    member.getStatus(),
                    member.getGrade()
            );
        }
    }
}
