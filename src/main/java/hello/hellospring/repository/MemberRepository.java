package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장
    Optional<Member> findById(Long id); // 아이디 조회
    Optional<Member> findByName(String name); // 이름으로 조회
    List<Member> findAll(); // 전체 조회
}
