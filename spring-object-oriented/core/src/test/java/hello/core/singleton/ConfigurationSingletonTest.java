package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository2 = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository = memberService.getMemberRepository();
        MemberRepository memberRepository1 = orderService.getMemberRepository();

        System.out.println("memberService -> memoryRepository = " + memberRepository);
        System.out.println("orderService -> memoryRepository = " + memberRepository1);
        System.out.println("memoryRepository = " + memberRepository2);

        Assertions.assertThat(memberRepository).isSameAs(memberRepository1);
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);




    }

    @Test
    void configurationDeep(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }
}
