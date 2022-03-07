package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //스프링 컨테이너에 등록 하고 사용하는게좋다.
    private final MemberService memberService;

    // DI를 통해서 스프링 컨테이너에서 넣어준다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
