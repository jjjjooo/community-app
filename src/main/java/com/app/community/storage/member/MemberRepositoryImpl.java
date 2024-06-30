package com.app.community.storage.member;

import com.app.community.domain.member.Member;
import com.app.community.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final SpringDataMemberRepository springDataMemberRepository;

    @Override
    public Optional<Member> findById(Long memberId) {
        return springDataMemberRepository.findById(memberId)
                .map(MemberEntity::toDomain);
    }

    @Override
    public Optional<Member> findBySocial(String socialId, String socialProvider) {
        return springDataMemberRepository.findBySocial(socialId, socialProvider)
                .map(MemberEntity::toDomain);
    }

    @Override
    public Member save(Member member) {
        return springDataMemberRepository.save(MemberEntity.fromDomain(member)).toDomain();
    }

    @Override
    public Member update(Member member) {
        return null;
    }

}
