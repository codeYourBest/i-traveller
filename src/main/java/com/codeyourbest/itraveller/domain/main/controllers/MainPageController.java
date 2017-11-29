package com.codeyourbest.itraveller.domain.main.controllers;

import com.codeyourbest.itraveller.domain.search.model.SearchingParameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    public static final String MAIN_VIEW_NAME = "index";

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("searchingParameters", new SearchingParameters());
        return MAIN_VIEW_NAME;
    }

}

