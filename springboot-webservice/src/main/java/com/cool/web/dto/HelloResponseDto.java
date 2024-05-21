package com.cool.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Getter
@RequiredArgsConstructor
@GetMapping("hello/dto")
public class HelloResponseDto {
    private final String name;
    private final int amount;
    }
}
