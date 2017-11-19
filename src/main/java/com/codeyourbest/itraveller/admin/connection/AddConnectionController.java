package com.codeyourbest.itraveller.admin.connection;

import com.codeyourbest.itraveller.search.connection.Connection;
import com.codeyourbest.itraveller.search.connection.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddConnectionController {

    final static String ADD_CONNECTION_VIEW = "newConnection";

    private ConnectionRepository connectionRepository;

    @Autowired
    public AddConnectionController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/addConnection")
    public String addConnection(
            @RequestParam(value="from") String from,
            @RequestParam(value="to") String to,
            Model model) {
        Connection connection = new Connection(from, to);
        connectionRepository.save(connection);
        model.addAttribute(connection);
        return ADD_CONNECTION_VIEW;
    }
}
