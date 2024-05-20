package com.cool;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game game = new BaseBallGame(5);
        game.setDifficulty(3);
        try {
            game.startGame();

        } catch (Exception e){

            e.printStackTrace();
        }
    }
}