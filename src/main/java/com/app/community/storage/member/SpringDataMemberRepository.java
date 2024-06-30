package com.app.community.storage.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SpringDataMemberRepository extends JpaRepository<MemberEntity, Long> {

    @Query("""
            SELECT m FROM MemberEntity m
            WHERE (m.socialProvider = :socialProvider)
            AND (m.socialId = :socialId)
            """
    )
    Optional<MemberEntity> findBySocial(String socialId, String socialProvider);

    Boolean existsByNickname(String nickname);
}
