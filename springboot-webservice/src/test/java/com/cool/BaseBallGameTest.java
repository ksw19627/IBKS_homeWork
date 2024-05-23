package com.cool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {

    @Test
    public void testcase_digits6() {
        BaseBallGame game = new BaseBallGame();
        game.setDigits(6);
        String given = "325687";
        String input = "125843";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S2B");
        input = "123456";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S3B");
        input = "456789";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S3B");
        input = "132548";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S4B");
        input = "328567";
        assertThat(game.getScore(given, input).toString()).isEqualTo("3S3B");
    }

    @Test
    public void testcase_digits5() {
        BaseBallGame game = new BaseBallGame();
        game.setDigits(5);
        String given = "32568";
        String input = "12584";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S1B");
        input = "85236";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S5B");
        input = "82536";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S3B");
        input = "82563";
        assertThat(game.getScore(given, input).toString()).isEqualTo("3S2B");
        input = "32568";
        assertThat(game.getScore(given, input).toString()).isEqualTo("5S0B");
    }

    @Test
    public void testcase_digits4(){
        BaseBallGame game = new BaseBallGame();
        game.setDigits(4);
        String given = "6183";
        String input = "1234";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S2B");
        input = "4163";
        assertThat(game.getScore(given, input).toString()).isEqualTo("2S1B");
        input = "8795";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S1B");
        input = "1863";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S3B");
        input = "1638";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S4B");
        input = "6283";
        assertThat(game.getScore(given, input).toString()).isEqualTo("3S0B");
        input = "6183";
        assertThat(game.getScore(given, input).toString()).isEqualTo("4S0B");
    }

    @Test
    public void testcase_digits3(){
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
        input = "132";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S2B");
        input = "213";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S2B");
        input = "321";
        assertThat(game.getScore(given, input).toString()).isEqualTo("1S2B");
        input = "264";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S1B");
        input = "367";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S1B");
        input = "231";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S3B");
        input = "312";
        assertThat(game.getScore(given, input).toString()).isEqualTo("0S3B");
        input = "123";
        assertThat(game.getScore(given, input).toString()).isEqualTo("3S0B");
    }
}


