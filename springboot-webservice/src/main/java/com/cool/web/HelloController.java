package com.cool.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ① JSON을 반환하는 controller를 만들어준다
public class HelloController {
    @GetMapping("/hello") // ② HTTP Get Method 요청만 받는다.
    public String hello() {
        return "hello";
    }
}
