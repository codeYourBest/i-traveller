package com.codeyourbest.itraveller.domain.search;

import com.codeyourbest.itraveller.domain.search.persistance.Connection;
import com.codeyourbest.itraveller.domain.search.repositories.ConnectionRepository;
import lombok.val;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static com.codeyourbest.itraveller.domain.search.SearchController.NO_RESULTS_VIEW;
import static com.codeyourbest.itraveller.domain.search.SearchController.SEARCHING_RESULTS_VIEW;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SearchControllerTest {

    private static final String FROM_PLACE = "Krakow";
    private static final String TO_PLACE = "Tarnow";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private ConnectionRepository connectionRepository;

    @InjectMocks
    private SearchController controller;

    @Test
    public void shouldDisplayNoResultsIfNoConnectionFound() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();
        when(connectionRepository.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(post("/search")
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

        mockMvc.perform(post("/search")
                .param("from", FROM_PLACE)
                .param("to", TO_PLACE))
                .andExpect(view().name(SEARCHING_RESULTS_VIEW));
    }

}