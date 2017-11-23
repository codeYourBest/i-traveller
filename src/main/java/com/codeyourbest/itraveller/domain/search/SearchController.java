package com.codeyourbest.itraveller.search.controller;

import com.codeyourbest.itraveller.domain.search.ConnectionRepository;
import com.codeyourbest.itraveller.domain.search.persistance.Connection;
import com.codeyourbest.itraveller.search.model.SearchingParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Karol Banyś.
 */

@Controller
public class SearchController {

    private static final String SEARCHING_RESULTS_VIEW = "searchingResults";

    private static final String NO_RESULTS_VIEW = "noResults";

    private ConnectionRepository connectionRepository;

    @Autowired
    public SearchController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @PostMapping("/search")
    public String showConnections(final SearchingParameters searchingParameters, final Model model) {
        List<Connection> connectionsFound = connectionRepository.findAll();
        if (connectionsFound.size() > 0) {
            model.addAttribute("connections", connectionsFound);
            return SEARCHING_RESULTS_VIEW;
        }
        return NO_RESULTS_VIEW;
    }
}
