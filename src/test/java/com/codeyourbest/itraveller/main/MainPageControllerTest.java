package com.codeyourbest.itraveller.main;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MainPageControllerTest {

    @Test
    public void shouldShowMainPage() throws Exception {
        MainPageController controller = new MainPageController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("index"));
    }

    @Test
    public void shouldProcessSearching() throws Exception {
        MainPageController controller = new MainPageController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/")
                .param("from", "Kraków")
                .param("to", "Warszawa"))
                .andExpect(view().name("noResults"));
    }
}