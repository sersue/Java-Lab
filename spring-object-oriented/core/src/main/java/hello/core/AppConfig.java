package hello.core;

import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
        /*
        1. MemoryMemberRepository 객체 생성
        2. MemberServiceImpl생성 + MemoryMemberRepository 객체의 참조값 주입
          MemberServiceImpl입장에선 의존 관계를 외부에서 주입하는 것처럼 보여서
          DI(Dependency Injection)이라고 함
        */
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}
