package hello.servlet.domain;

import hello.servlet.domain.member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 고려
 */

public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    //싱글톤
    protected static final MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // Id로 회원 조회
    public Member findById(Long id) {
        return store.get(id);
    }

    // store에 있는 모든 값들을 꺼내서, ArrayList에 넘겨줌
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // stroe 초기화
    public void clearStore() {
        store.clear();
    }
}
