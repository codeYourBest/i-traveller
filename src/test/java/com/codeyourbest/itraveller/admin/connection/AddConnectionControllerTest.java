package com.codeyourbest.itraveller.admin.connection;

import com.codeyourbest.itraveller.domain.search.connection.ConnectionRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;

import static com.codeyourbest.itraveller.admin.connection.AddConnectionController.ADD_CONNECTION_VIEW;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class AddConnectionControllerTest {
    private static final String FROM_PLACE = "Kraków";
    private static final String TO_PLACE = "Warszawa";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private ConnectionRepository connectionRepository;
    @InjectMocks
    private AddConnectionController controller;

    @Test
    public void shouldShowMainPage() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/addConnection")
                .param("from", FROM_PLACE)
                .param("to", TO_PLACE))
                .andExpect(view().name(ADD_CONNECTION_VIEW));
    }

}
