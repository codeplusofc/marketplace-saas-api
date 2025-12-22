package com.market.saas;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnBadRequestWhenProductNameIsMissing() throws Exception {

        String invalidProductJson = "{\"productPrice\": 10.0, \"quantity\": 5}";

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidProductJson))
                .andExpect(status().isBadRequest()); 
    }
}