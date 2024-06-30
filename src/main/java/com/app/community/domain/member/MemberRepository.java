package com.app.community.domain.member;

import java.util.Optional;

public interface MemberRepository {
    /** 생성 수정 전용 */
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findBySocial(String socialId, String socialProvider);
    Member update(Member member);

    /** 조회 전용 쿼리 */

}
