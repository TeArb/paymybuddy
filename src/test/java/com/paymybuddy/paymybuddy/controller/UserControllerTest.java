package com.paymybuddy.paymybuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymybuddy.paymybuddy.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;
    @MockBean
    private UserServiceImpl userService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void showHomeForm() {
    }

    @Test
    void login() {
    }

    @Test
    void getUsers() {
    }

    @Test
    void registrationForm() throws Exception {
        this.mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("/register"));
    }

    @Test
    void registration() throws Exception {
        this.mockMvc
                .perform(post("/register")
                        .param("firstName", "John")
                        .param("lastName", "Doe")
                        .param("birthdate", "1990-01-01")
                        .param("phoneNumber", "0123456789")
                        .param("email", "john@gmail.com")
                        .param("password", "123"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection())
                        .andExpect(header().string("Location", "/register?success"));

    }

    @Test
    void deleteUser() {
    }
}