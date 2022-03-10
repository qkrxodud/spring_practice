package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

//이전에 실행 시켰던 것을 다시 재실행 shift + F10
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given 주어주다
        Member member1 = new Member();
        member1.setName("hello");

        // when 실행했을때
        memberService.join(member1);

        // then 결과값
        Assertions.assertThat(memberService.findOne(member1.getId()).get().equals(member1));
    }

    @Test
    void 중복_회원_예외() {
        //given 주어주다
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when 실행했을때
        memberService.join(member1);
        //then
        assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
    }

    @Test
    void 회원조회() {
        Member member1 = new Member();
        member1.setName("typark");
        memberService.findByName(member1.getName());
        Assertions.assertThat(memberService.findMembers().size()).isEqualTo(1);
    }
}