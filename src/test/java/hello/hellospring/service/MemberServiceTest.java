package hello.hellospring.service;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {
    private MemoryMemberRepository memberRepository;
    MemberService memberService;

    @Test
    void 회원가입() {
        //given 이런 상황을 주어줬을대
        Member member = new Member();
        member.setName("number1");

        //when 이것을 실행 해준다.
        Long saveId = memberService.join(member);

        //then 결과값이 나온다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {

    }

    @Test
    void validateDuplicateMember() {
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}