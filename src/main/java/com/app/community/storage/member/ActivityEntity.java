package com.app.community.storage.member;

import com.app.community.domain.member.Activity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "activity")
@Entity
public class ActivityEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private String description;
    private String relatePath;

    public static ActivityEntity fromDomain(Activity activity){
        return ActivityEntity.builder()
                .id(activity.getId())
                .memberId(activity.getMemberId())
                .description(activity.getDescription())
                .relatePath(activity.getRelatePath())
                .build();
    }
}
