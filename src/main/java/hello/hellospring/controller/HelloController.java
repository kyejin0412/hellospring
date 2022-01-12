package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //url 매칭
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
        //데이터를 넘겨주며 resources/templates/에서 hello.html을 찾음
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        //name에 값을 담아서 model에 담아 html로 넘긴다.
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    // HttpMessageConverter가 동작 -> 전달하는게 string이므로 StringConverter가 동작
    // http의 바디 부분에 데이터("hello " + name)를 직접 넣어주겠다는 의미
    // mvc는 html 형식에서 조작하는 방식이고, api는 데이터만 그대로 내려줌.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    // HttpMessageConverter가 동작 -> 전달하는게 객체이므로 JsonConverter가 동작
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        //객체 전달할때는 객체를 json 형식으로 만들어서 웹브라우저에 전달
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
