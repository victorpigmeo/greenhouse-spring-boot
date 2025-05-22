package dev.pigmeo.greenhouse.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTemperature_shouldReturnDht() throws Exception {
        mockMvc.perform(get("/api/dht"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.temperature").exists())
                .andExpect(jsonPath("$.humidity").exists())
                .andExpect(jsonPath("$.heat_index").exists());
    }

    @Test
    public void getTemperature_shouldFailFromDhtServer() throws Exception {
        @SuppressWarnings("unchecked")// Mockito can't know about generics
        HttpResponse<String> mockedFailedResponse = (HttpResponse<String>) Mockito.mock(HttpResponse.class);
        Mockito.when(mockedFailedResponse.statusCode()).thenReturn(500);

        mockMvc.perform(get("/api/dht"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.temperature").exists())
                .andExpect(jsonPath("$.humidity").exists())
                .andExpect(jsonPath("$.heat_index").exists());
    }

}
