package oleg.podolyan.svatoapiboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/")
    public String index(Principal principal){
        System.out.println("m: index is invoked with user " + principal.getName());
        return "Hello " + principal.getName() + "!";
    }
}
