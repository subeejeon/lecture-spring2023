package hello.servlet.domain;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    // 테스트 할 대상, 싱글톤
    MemberRepository memberRepository = MemberRepository.getInstance();

    // 테스트 종료 후 초기화
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());

        //찾아온 멤버는 저장된 멤버랑 같아야 한다.
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("a", 20);
        Member member2 = new Member("b", 30);
        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> result = memberRepository.findAll();
        //then
        //개수와 member1, member2가 있는지 확인한다
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.contains(member1));
        Assertions.assertThat(result.contains(member2));

    }
}
