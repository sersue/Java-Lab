package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회 : 호출할때마다 객체 생성

        MemberService memberService2 = appConfig.memberService();
        //참조값이 다른 걸 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);



    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용 ")
    void singletonServiceTest(){
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance1 = SingletonService.getInstance();

        System.out.println("instance = " + instance);
        System.out.println("instance1 = " + instance1);

        Assertions.assertThat(instance).isSameAs(instance1);


    }
}
