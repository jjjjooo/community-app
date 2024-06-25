package com.app.community.domain.member;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class Member {

    private @Nullable Long id;
    private @NotNull String socialId;
    private @NotNull String socialProvider;
    private @Nullable String email;
    private @NotNull String nickname;
    private @Nullable String profileImagePath;
    private int point;
    private int money;
    private int chatPeePoint;
    private boolean chatRefusal;
    private @NotNull MemberPosition position;
    private @NotNull MemberStatus status;
    private @NotNull MemberGrade grade;

    public enum MemberStatus {
        ACTIVE, INACTIVE, SUSPENSE
    }

    public enum MemberGrade {
        BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, RUBY
    }

    public enum MemberPosition {
        NONE, DEVELOPER
    }

    @Builder
    private Member(
            @Nullable Long id,
            @NotNull String socialId,
            @NotNull String socialProvider,
            @NotNull String nickname,
            @Nullable String email,
            @Nullable String profileImagePath,
            @NotNull Integer point,
            @NotNull Integer money,
            @NotNull Integer chatPeePoint,
            @NotNull Boolean chatRefusal,
            @NotNull MemberPosition position,
            @NotNull MemberStatus status,
            @NotNull MemberGrade grade
    ) {
        this.id = id;
        this.socialId = socialId;
        this.socialProvider = socialProvider;
        this.email = email;
        this.nickname = nickname;
        this.profileImagePath = profileImagePath;
        this.point = point;
        this.money = money;
        this.chatPeePoint = chatPeePoint;
        this.chatRefusal = chatRefusal;
        this.position = position;
        this.status = status;
        this.grade = grade;
    }

    public static Member registerBySocial(
            @NotNull String socialId,
            @NotNull String socialProvider
    ){
        return Member.builder()
                .socialId(socialId)
                .socialProvider(socialProvider)
                .point(0)
                .money(0)
                .grade(MemberGrade.BRONZE)
                .status(MemberStatus.SUSPENSE)
                .chatRefusal(false)
                .chatPeePoint(5)
                .build();
    }

    public void onboard(String nickname, MemberPosition memberPosition) {
        this.nickname = nickname;
        this.position = memberPosition;
    }

    public void updateSettings(Boolean chatRefusal, Integer chatPeePoint) {
        this.chatPeePoint = chatPeePoint;
        this.chatRefusal = chatRefusal;
    }
}