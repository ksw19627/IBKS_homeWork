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
        input = "425";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S0B");
        input = "453";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S0B");
        input = "126";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S0B");
        input = "153";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S0B");
        input = "523";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S0B");
        input = "123";
        assertThat(game.getScore(given, input).toString()).isEqualTo("3S0B");
    }

    @Test
    public void test_case2(){
        String given = "123";
        String input = "132";
        BaseBallGame game = new BaseBallGame();
        //BaseBallGame.GameResult output = game.getScore(given, input);
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S2B");
        input = "213";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S2B");
        input = "321";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S2B");
    }

    @Test
    public void test_case3(){
        String given = "123";
        String input = "572";
        BaseBallGame game = new BaseBallGame();
        //BaseBallGame.GameResult output = game.getScore(given, input);
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S1B");
        input = "264";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S1B");
        input = "367";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S1B");
        input = "231";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S3B");
        input = "312";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S3B");
    }

}


