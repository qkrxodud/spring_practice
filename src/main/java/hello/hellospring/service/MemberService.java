package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService  {
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    // 서비스는 비지니스 로직에 맞게 네이밍을 사용하는게 좋다.
    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(Member member) {
        memberRepository.finByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재합니다.");
        });
    }

    /**
     * 전체 회원 조회회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 한개 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.finById(memberId);
    }
}