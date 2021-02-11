package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
        AppConfig appConfig =new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId=1L;
        Member member= new Member(memberId,"MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, 20000, "itemA");

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculaterPrice());


    }
}
