package com.cool.web.dto;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

class HelloResponseDtoTest {
    public void test_lombok(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount().isEqualTo(amount));
    }

}