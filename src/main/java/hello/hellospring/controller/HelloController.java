package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 기본 정적페이지
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // 데이터 맵핑 후 전달
    @GetMapping("hello-pattern_01")
    public String hello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    // json 형식 전달
    @GetMapping("hello-api")
    @ResponseBody
    public HelloWorld helloAPI(@RequestParam("name") String name, Model model) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName(name);
        return helloWorld;
    }

    static class HelloWorld {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
