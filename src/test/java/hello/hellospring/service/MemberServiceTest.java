package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

//이전에 실행 시켰던 것을 다시 재실행 shift + F10
class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

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

    /*
        try {
            memberService.join(member2);
            fail();
        } catch ( IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
    */
    }

    @Test
    void 회원조회() {
        Member member1 = new Member();
        member1.setName("spring3");
        memberService.join(member1);
        Assertions.assertThat(memberService.findMembers().size()).isEqualTo(1);
    }

    @Test
    void findOne() {
        Member member1 = new Member();
        member1.setName("spring");
        memberService.join(member1);
        Assertions.assertThat(memberService.findOne(member1.getId()).get()).isEqualTo(member1);
    }
}