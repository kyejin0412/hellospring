package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
//    아무것도 없을땐 home화면으로 감. 기본화면
    public String home() {
        return "home";
    }
}
