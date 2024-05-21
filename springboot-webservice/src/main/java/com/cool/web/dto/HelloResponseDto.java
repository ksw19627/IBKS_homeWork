package com.cool.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@GetMapping("hello/dto")
public  HelloResponseDto {
    private final String name;
    private final int amount;
}
