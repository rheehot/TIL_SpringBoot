package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
/* 다음과 같이 리팩토링 한 결과, 중복을 제거하고 역할에 따른 구현이 보이게 된다.
* 또한 SRP(단일 책임 원칙), DIP(의존관계 역전 원칙) 적용됨.

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
//        할인 정책 변경(OCP 원칙 잘 지켜짐)
        return new RateDiscountPolicy();
    }*/

    // Spring 기반으로 변경하기. @Configuration, @Bean으로 등록.
    // 스프링 컨테이너에 스프링 빈으로 등록하는 과정임.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
//        할인 정책 변경(OCP 원칙 잘 지켜짐)
        return new RateDiscountPolicy();
    }
}
