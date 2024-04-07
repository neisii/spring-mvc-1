package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
  private Map<Long, Member> store = new HashMap<>();
  private long sequence = 0L;


  private static final MemberRepository instance = new MemberRepository();

  public static MemberRepository getInstance() {
    return instance;
  }

  // 생성자를 못 만들게 private
  private MemberRepository() {
  }

  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  public Member findById(Long memberId) {
    return store.get(memberId);
  }

  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  public void clearStore() {
    store.clear();
  }
}
