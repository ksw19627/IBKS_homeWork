package com.cool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

abstract class Game{
	@Setter
	@Getter
    private int gameCount = 5, digits = 3;
	public String answer;

	abstract void startGame() throws Exception;
	abstract boolean gameEnd() throws Exception;
}

@NoArgsConstructor
class BaseBallGame extends Game {

	public BaseBallGame(int gameCount, int digits) {
		super();
		setDigits(digits);
		setGameCount(gameCount);
	}

	@AllArgsConstructor
	public class GameResult{
		@Getter
		private int strike, ball;

		@Override
		public String toString() {
			return (strike+"S"+ball+"B");
		}
	}

	public void makeNumber(){
		answer = "";
		while(true){
			CharSequence item = Integer.toString((int)(Math.random() * 10));
			if(!answer.contains(item))
				answer += item;

			if (answer.length() == getDigits()) {
				System.out.println("Number has been created");
				break;
			}
		}
	}

	@Override
	public void startGame() throws Exception{
		makeNumber();
		for(int i=0; i<this.getGameCount(); i++){
			System.out.println("Your leftCount: " + (getGameCount() - i));
			if(gameEnd()){
				System.out.println("You Win!!!");
				break;
			}
		}
		System.out.println("Game ended");
	}

	@Override
	public boolean gameEnd() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			if(input.length() != getDigits()) {
				throw new IllegalArgumentException();
			}
			Integer.parseInt(input);

			GameResult gameResult = getScore(answer, input);
			System.out.println(gameResult.toString());
			if(gameResult.getStrike() == getDigits()){
				return true;
			}
		}
		catch (NumberFormatException e){
			System.out.println("The input is not a number. Please check again.");
			setGameCount(getGameCount() + 1);
		}
		catch(IllegalArgumentException e){
			System.out.println("The input's digits does not match. Please check again.");
			setGameCount(getGameCount() + 1);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

	public GameResult getScore(String given, String input){
		Set<Character> interSection = new HashSet<>(given.chars()
				.mapToObj(e->(char)e).collect(Collectors.toSet()));
		interSection.retainAll(input.chars()
				.mapToObj(e->(char)e).collect(Collectors.toSet()));

		int ball = interSection.size();
		int strike = 0;
		//System.out.println("answer: " + given);
		for(int i=0; i<getDigits(); i++){
			if(given.charAt(i) == (input.charAt(i))) {
				strike++;
			}
		}
		ball -= strike;
		return new GameResult(strike,ball);
	}
}

// for standalone game mode
class Play {
	public static void main(String[] args){
		try {
			Game game = new BaseBallGame(5,3);
			game.startGame();
		} catch (Exception e){
			e.printStackTrace();
		}
    }
}
