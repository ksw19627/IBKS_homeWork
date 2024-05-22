package com.cool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {
    @Test
    public void test_case1(){
        String given = "123";
        String input = "456";
        BaseBallGame game = new BaseBallGame();
        //BaseBallGame.GameResult output = game.getScore(given, input);
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S0B");
        input = "145";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S0B");
        input = "126";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S0B");
        input = "153";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S0B");
    }

}


