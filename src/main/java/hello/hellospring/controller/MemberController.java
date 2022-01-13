package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//이 컨트롤러 에노테이션을 보고 MemberController 객체 생성해서 스프링이 들고 관리함.
public class MemberController {

    private final MemberService memberService;

    @Autowired
    //MemberController가 생성될 때 스프링빈에 있는 memberService 객체를 넣어줌. ->DI
    //memberService를 스프링이 스프링 컨테이너에 있는 memberService와 연결시켜줌.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //생성자
}
