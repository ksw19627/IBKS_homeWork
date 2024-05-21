package com.cool.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class) // ①
@WebMvcTest // ②
public class HelloControllerTest {
    @Autowired //  ➂
    private MockMvc mvc; //  ➃

    public HelloControllerTest(MockMvc mvc){

    }
    @Test
    public void hello_return() throws Exception {
        String hello = "hello";
        mvc.perform(MockMvcRequestBuilders.get("/hello")) // ➄
                .andExpect(status().isOk()) // ➅
                .andExpect(content().string(hello)); // ➆
    }
}


