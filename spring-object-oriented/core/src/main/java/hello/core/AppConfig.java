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

// new 연산자로 두번이상 불려도 spring singleton에 의해 한번씩만 호출됨.
//AppConfig.memberService
//AppConfig.memberRepository
//AppConfig.orderService

//@Configuration에 의해 AppConfig를 상속하는 AppConfig@CGLIB가 생성되고 그게 스프링 컨테이너에 들어감
//객체가 있으면 생성하지 않고, 없으면 AppConfig로직 실행
//Configuration 떼면 싱글톤 깨짐
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
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
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
