package hello.core.Member;

public class MemberServiceImpl implements MemberService{
    //구현체가 하나일 때는 관례상 +Impl을 붙임

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); //OCP, DIP 위반
    private final MemberRepository memberRepository; //config 생성

    //생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //생성자를 통해서 repository에 뭐가 들어갈지 결정 //DIP 규칙 지킴
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
