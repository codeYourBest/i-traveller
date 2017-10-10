package com.codeyourbest.itraveller.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainPageController {

    //Injecting property
    @Value("${spring.mvc.view.prefix:}")
    private String prefix = "";

    @GetMapping()
    public String index() {
        return "index";
    }

    @PostMapping()
    public String indexSubit() {
        return "searchResults";
    }

}

