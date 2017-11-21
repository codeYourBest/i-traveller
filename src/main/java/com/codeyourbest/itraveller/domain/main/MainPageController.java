package com.codeyourbest.itraveller.domain.main;

import com.codeyourbest.itraveller.domain.search.persistance.Connection;
import com.codeyourbest.itraveller.domain.search.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainPageController {

    public static final String MAIN_VIEW_NAME = "index";
    public static final String NO_RESULTS_VIEW = "noresults";
    public static final String SEARCHING_RESULTS = "searchingResults";

    private ConnectionRepository connectionRepository;

    @Autowired
    public MainPageController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/")
    public String index() {
        return MAIN_VIEW_NAME;
    }

    @PostMapping("/")
    public String searchSubmit(Model model) {
        List<Connection> connectionsFound = connectionRepository.findAll();
        if (connectionsFound.size() > 0) {
            model.addAttribute("connections", connectionsFound);
            return SEARCHING_RESULTS;
        }
        return NO_RESULTS_VIEW;
    }

}

