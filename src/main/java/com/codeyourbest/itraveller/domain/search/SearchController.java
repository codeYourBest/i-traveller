package com.codeyourbest.itraveller.domain.search;

import com.codeyourbest.itraveller.domain.search.model.SearchingParameters;
import com.codeyourbest.itraveller.domain.search.persistance.Connection;
import com.codeyourbest.itraveller.domain.search.repositories.ConnectionRepository;
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

    public static final String SEARCHING_RESULTS_VIEW = "searchingResults";

    public static final String NO_RESULTS_VIEW = "noResults";

    private ConnectionRepository connectionRepository;

    @Autowired
    public SearchController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    /*@GetMapping("/search")
    public String greetingForm(final Model model) {
        model.addAttribute("searchingParameters", new SearchingParameters());
        return NO_RESULTS_VIEW;
    }*/

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
