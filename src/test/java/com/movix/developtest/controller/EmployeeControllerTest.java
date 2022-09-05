package com.movix.developtest.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Test
    public void searchEmployeeByName_returnsOk() throws Exception {
        final String search = "ariel";

        this.mvc.perform(get("/api/employee/search/{parameter}", search).contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(status().isOk()) //
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.status.code", equalTo(200))) //
                .andExpect(jsonPath("$.result", Matchers.hasSize(1))) //
                .andDo(print());

    }

    @Test
    public void searchEmployeeByLastName_returnsOk() throws Exception {
        final String search = "bustos";

        this.mvc.perform(get("/api/employee/search/{parameter}", search).contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(status().isOk()) //
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.status.code", equalTo(200))) //
                .andExpect(jsonPath("$.result", Matchers.hasSize(1))) //
                .andDo(print());

    }

    @Test
    public void searchEmployeeByName_NoOk() throws Exception {
        final String search = "xx";

        this.mvc.perform(get("/api/employee/search/{parameter}", search).contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(status().isOk()) //
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.status.code", equalTo(404))) //
                .andDo(print());

    }
}
