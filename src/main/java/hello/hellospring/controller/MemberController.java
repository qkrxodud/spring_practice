package hello.hellospring.controller;

import hello.hellospring.service.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
