package hello.core.Member;

public class MemberServiceImpl implements MemberService{
    //구현체가 하나일 때는 관례상 +Impl을 붙임

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //OCP, DIP 위반
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
