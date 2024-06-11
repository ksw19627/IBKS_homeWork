package com.cool.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class) // ①
@WebMvcTest // ②
public class HelloControllerTest {
    @Autowired //  ➂
    private MockMvc mvc; //  ➃


    @Test
    public void hello_return() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) // ➄
                .andExpect(status().isOk()) // ➅
                .andExpect(content().string(hello)); // ➆
    }


    @Test
    public void helloDto_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(MockMvcRequestBuilders.get("/hello")
                .param("name", name)
                .param("amount", String.valueOf(amount)))// ➄
                .andExpect(status().isOk()) // ➅
                .andExpect(content().string(name)); // ➆
    }
}


