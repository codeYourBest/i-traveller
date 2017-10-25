package com.codeyourbest.itraveller.main;

import com.codeyourbest.itraveller.search.connection.Connection;
import com.codeyourbest.itraveller.search.connection.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainPageController {

    static final String MAIN_VIEW_NAME = "index";
    static final String NO_RESULTS_VIEW = "noresults";
    static final String SEARCHING_RESULTS = "searchingResults";

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

