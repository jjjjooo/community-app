package com.app.community.api.member;

import com.app.community.domain.member.AuthMemberService;
import com.app.community.domain.member.Member;
import com.app.community.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@RestController
public class MemberController {

    private final AuthMemberService authMemberService;

    @PostMapping("/register")
    public void register(MemberRequest.RegisterRequest request){
        authMemberService.authentication(request.socialId(), request.socialProvider());
    }
}
