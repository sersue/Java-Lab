package hello.core.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    //구현체가 하나일 때는 관례상 +Impl을 붙임

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); //OCP, DIP 위반
    private final MemberRepository memberRepository; //config 생성

    @Autowired // 설정 파일이 없어지기 때문에 의존관계 주입을 직접 해줘야 함 MemberRepository 타입에 맞는거로  자동으로 주입해줌
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

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
