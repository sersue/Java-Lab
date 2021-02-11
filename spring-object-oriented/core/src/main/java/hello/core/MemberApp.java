package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        Member member1 = new Member(2L, "memberB", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("find Member = " + findMember.getName());
        System.out.println("new member = " + member.getName());
    }
}
