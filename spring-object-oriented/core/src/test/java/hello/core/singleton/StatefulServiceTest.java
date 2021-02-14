package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleTon(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);
        
        //ThreadA : 사용자 A , 10000원 주문
        int userAprice = bean1.order("userA",10000);
        //ThreadB : 사용자 B , 20000원 주문
        int userBprice =bean2.order("userB",20000);
        
//        int price = bean1.getPrice();
//        System.out.println("price = " + price);

//        Assertions.assertThat(bean1.getPrice()).isEqualTo(bean2.getPrice());
        System.out.println(userAprice);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
