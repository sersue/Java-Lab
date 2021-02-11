package hello.core.discount;

import hello.core.Member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
