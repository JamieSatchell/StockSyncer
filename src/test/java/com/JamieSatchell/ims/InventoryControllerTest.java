package com.JamieSatchell.ims;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(com.JamieSatchell.ims.InventoryController.class)
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Test message from Inventory Controller!"));
    }
}
