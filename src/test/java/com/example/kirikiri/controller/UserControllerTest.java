package com.example.kirikiri.controller;

import com.example.kirikiri.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void  findById() throws Exception{
//        Assertions.assertThat(((UserVO)mockMvc.perform(MockMvcRequestBuilders.get("/findAccount")
//                .param("userEmail", "test@email.com"))
//                .andReturn().getModelAndView().getModel().get("userId")).getUserId()).isEqualTo("testId");



        log.info("ID : " + mockMvc.perform(MockMvcRequestBuilders.get("/checkEmail")
                .param("userEmail", "test@email.com"))
                .andReturn().getModelAndView().getModel());


    }

    @Test
    public void changePw() throws Exception {
        UserVO userVO = new UserVO();

        userVO.setUserId("testId");
        userVO.setUserPassword("testpass");

        mockMvc.perform(MockMvcRequestBuilders.post("/passwordResetCompletion")
            .param("userId", userVO.getUserId())
            .param("userPassword", userVO.getUserPassword())
            ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }


}
