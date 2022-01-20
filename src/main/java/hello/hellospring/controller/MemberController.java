package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//컴포넌트 스캔 방법
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

    @GetMapping("/members/new")
//    /members/new로 url을 연결해줌. get은 데이터를 조회할때
    public  String createFrom() {
        return "members/createMemberForm";
//        보여지는 화면은 members/createMemberForm
    }

    @PostMapping("/members/new")
//    post는 데이터를 등록할때
    public String create(MemberForm form) {
//        전달받은 name값을 MemberForm의 setName으로 등록함
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
//        회원 등록 후 다시 홈화면으로 연결
    }

    @GetMapping("/members")
    public  String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
//        model에 addAttribute로 모든 회원들을 리스트에 담아놈. members가 키값.
        return "members/memberList";
    }
}
