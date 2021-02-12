package hello.core;

import hello.core.Member.MemberRepository;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
        /*
        1. MemoryMemberRepository 객체 생성
        2. MemberServiceImpl생성 + MemoryMemberRepository 객체의 참조값 주입
          MemberServiceImpl입장에선 의존 관계를 외부에서 주입하는 것처럼 보여서
          DI(Dependency Injection)이라고 함
        */
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
