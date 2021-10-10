package com.dazgs.templateapi.web.controller;

import com.dazgs.templateapi.base.AbstractWebIntegrationTest;
import net.minidev.json.JSONArray;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class AccountController extends AbstractWebIntegrationTest {

    @Test
    void findAll() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.length()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.isA(JSONArray.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].username", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].enabled", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].createdOn", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].updatedOn", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].password").doesNotExist());
    }

}
