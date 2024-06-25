package com.app.community.storage.member;

import com.app.community.domain.member.Member;
import com.app.community.storage.AbstractEntity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@Entity
public class MemberEntity extends AbstractEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socialId;
    private String socialProvider;
    private String email;
    private String nickname;
    private String profileImagePath;
    private int point;
    private int money;

    public static MemberEntity fromDomain(Member member){
       return MemberEntity.builder()
               .id(member.getId())
               .socialId(member.getSocialId())
               .socialProvider(member.getSocialProvider())
               .email(member.getEmail())
               .nickname(member.getNickname())
               .profileImagePath(member.getEmail())
               .point(member.getPoint())
               .money(member.getMoney())
               .build();
    }

    public Member toDomain(){
       return Member.builder()
                .id(this.getId())
                .socialId(this.getSocialId())
                .socialProvider(this.getSocialProvider())
                .email(this.getEmail())
                .nickname(this.getNickname())
                .profileImagePath(this.getEmail())
                .point(this.getPoint())
                .money(this.getMoney())
                .build();
    }
}
