package com.cool.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(org.springframework.test.context.junit4.SpringRunner.class) // ①
@WebMvcTest // ②
public class HelloControllerTest {
    @Autowired //  ➂
    private MockMvc mvc; //  ➃

    @Test
    public void hello_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(MockMvcRequestBuilders.get("/hello")
                .param("name", name)
                .param("amount", String.valueOf(amount)))// ➄
                .andExpect(status().isOk()) // ➅
                .andExpect(content().string(name)); // ➆
    }
}


