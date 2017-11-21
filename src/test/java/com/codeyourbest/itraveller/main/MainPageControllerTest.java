package com.codeyourbest.itraveller.main;

import com.codeyourbest.itraveller.domain.search.connection.Connection;
import com.codeyourbest.itraveller.domain.search.connection.ConnectionRepository;
import lombok.val;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static com.codeyourbest.itraveller.main.MainPageController.MAIN_VIEW_NAME;
import static com.codeyourbest.itraveller.main.MainPageController.NO_RESULTS_VIEW;
import static com.codeyourbest.itraveller.main.MainPageController.SEARCHING_RESULTS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MainPageControllerTest {

    private static final String FROM_PLACE = "Kraków";
    private static final String TO_PLACE = "Warszawa";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private ConnectionRepository connectionRepository;
    @InjectMocks
    private MainPageController controller;

    @Test
    public void shouldShowMainPage() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name(MAIN_VIEW_NAME));
    }

    @Test
    public void shouldDisplayNoResultsIfNoConnectionFound() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();
        when(connectionRepository.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(post("/")
                .param("from", FROM_PLACE)
                .param("to", TO_PLACE))
                .andExpect(view().name(NO_RESULTS_VIEW));
    }

    @Test
    public void shouldDisplayResultsIfFound() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();
        val connectionsFound = new ArrayList<Connection>();
        connectionsFound.add(new Connection(FROM_PLACE,TO_PLACE));
        when(connectionRepository.findAll()).thenReturn(connectionsFound);

        mockMvc.perform(post("/")
                .param("from", FROM_PLACE)
                .param("to", TO_PLACE))
                .andExpect(view().name(SEARCHING_RESULTS));
    }
}