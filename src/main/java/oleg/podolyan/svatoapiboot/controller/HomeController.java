package oleg.podolyan.svatoapiboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Principal principal){
        System.out.println("m: index is invoked with user " + principal.getName());
        return "Hello " + principal.getName() + "!";
    }
}
