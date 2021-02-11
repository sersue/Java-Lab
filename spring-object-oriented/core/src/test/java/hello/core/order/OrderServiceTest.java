package hello.core.order;

import hello.core.AppConfig;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService ;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long customerId = 1L;
        Member member = new Member(customerId,"kim", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(customerId, 10000, "kimbap");

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
