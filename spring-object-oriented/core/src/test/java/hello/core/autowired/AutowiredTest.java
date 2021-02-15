package hello.core.autowired;

import hello.core.Member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{
        //Member는 스프링 빈이 아님
    //의존관계 없으면 메소드 자체가 호출이 안됨 즉, soutv출력 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        //호출은 되되, null로 찍힘
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        //optional.empty로 찍힘
        @Autowired
        public void setNoBean3(Optional <Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }


    }
}
