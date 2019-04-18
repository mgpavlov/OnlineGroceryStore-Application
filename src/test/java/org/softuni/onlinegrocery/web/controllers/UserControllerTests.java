package org.softuni.onlinegrocery.web.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.softuni.onlinegrocery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserControllerTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserController userController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
    public void login_ReturnsCorrectView() throws Exception {
        this.mvc
                .perform(get("/login"))
                .andExpect(view().name("/login"));
    }

    @Test
    @Transactional
    public void register_ReturnsCorrectView() throws Exception {
        this.mvc
                .perform(get("/register"))
                .andExpect(view().name("register"));
    }

    @Test
    @Transactional
    public void register_failRegistersUserCorrectly_redirectCorrectly() throws Exception {
        this.mvc
                .perform(
                        post("/register")
                                .param("username", "mishoo")
                                .param("password", "mishoo")
                                .param("confirmPassword", "mishoo")
                                .param("address", "sofiaaaaaa")
                                .param("email", "misho@m.m")
                );
        Assert.assertEquals(0, this.userRepository.count());
    }
}