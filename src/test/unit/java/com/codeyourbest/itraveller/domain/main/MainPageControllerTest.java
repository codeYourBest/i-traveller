package com.codeyourbest.itraveller.domain.main;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static com.codeyourbest.itraveller.domain.main.MainPageController.MAIN_VIEW_NAME;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MainPageControllerTest {

    private MainPageController controller = new MainPageController();

    @Test
    public void shouldShowMainPage() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name(MAIN_VIEW_NAME));
    }
}