package com.app.community.api.member;

public class MemberRequest {

    public record RegisterRequest(
        String socialId,
        String socialProvider
    ){

    }
}
