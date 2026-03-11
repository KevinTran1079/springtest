package com.kevintran1079.springtest;


import com.kevintran1079.springtest.controller.UserController;
import com.kevintran1079.springtest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerContractTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        UserController userController = new UserController(new UserService());
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getUsersReturnsUsersList() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].username").value("Kevin"))
                .andExpect(jsonPath("$[0].email").value("kevin@test.com"))
                .andExpect(jsonPath("$[0].password").doesNotExist())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].username").value("Roy"))
                .andExpect(jsonPath("$[1].email").value("roy@test.com"))
                .andExpect(jsonPath("$[1].password").doesNotExist())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(result -> {
                    String contentType = result.getResponse().getContentType();
                    if (contentType == null || !MediaType.APPLICATION_JSON.isCompatibleWith(MediaType.parseMediaType(contentType))) {
                        throw new AssertionError("Expected application/json content type but was " + contentType);
                    }
                });
    }
}
