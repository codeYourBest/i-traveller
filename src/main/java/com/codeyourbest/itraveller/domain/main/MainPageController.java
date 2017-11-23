package com.codeyourbest.itraveller.domain.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    static final String MAIN_VIEW_NAME = "index";

    @GetMapping("/")
    public String index() {
        return MAIN_VIEW_NAME;
    }

}

