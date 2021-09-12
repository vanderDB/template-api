package com.dazgs.templateapi.web.controller;

import com.dazgs.templateapi.base.AbstractWebIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class UserController extends AbstractWebIntegrationTest {

    @Test
    void test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/all"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
