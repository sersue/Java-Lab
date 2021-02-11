package hello.core.order;

import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // DIP위반 : OrderServiceImpl이라는 객체가 DiscountPolicy는 RateDiscountPolicy를 써야한다고 지정
    // 레오나르도 디카프리오가 여주인공을 고르는 셈

    @Override
    public Order createOrder(Long memberId, int itemPrice, String itemName) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);



        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
