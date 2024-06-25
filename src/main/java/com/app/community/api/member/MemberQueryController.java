package com.app.community.api.member;

import com.app.community.domain.member.AuthMember;
import com.app.community.domain.member.Member;
import com.app.community.domain.member.MemberService;
import com.app.community.support.annotataion.AuthenticationMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.community.domain.member.MemberSummary.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@RestController
public class MemberQueryController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberInfo> me(
            @AuthenticationMember AuthMember authMember
    ) {
        Member member = memberService.getMemberInfo(authMember.getMemberId());
        return ResponseEntity.ok().body(MemberInfo.of(member));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberInfo> getMyProfile(
            @PathVariable(name = "memberId") Long memberId
    ) {
        Member member = memberService.getMemberInfo(memberId);
        return ResponseEntity.ok().body(MemberInfo.of(member));
    }
}
