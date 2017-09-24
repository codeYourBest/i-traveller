package com.codeyourbest.itraveller.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //Injecting property
    @Value("${spring.mvc.view.prefix:}")
    private String prefix = "";

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
