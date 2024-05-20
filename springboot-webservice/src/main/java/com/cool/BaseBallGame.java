package com.cool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

abstract class Game{
	private int gameCount = 5;
	private int digits = 3;

	public List<Character> answer;

	public Game(int count){
        setGameCount(count);
	}

	public void setGameCount(int count){
        this.gameCount = count;
	}
	public int getGameCount(){return gameCount;}

	public void setDifficulty(int digits){
		this.digits = digits;
	}
	public int getDifficulty(){return digits;}

	public void startGame() throws Exception {
		try {
			answer = new ArrayList<>();
			while(true){
				char item = Integer.toString((int)(Math.random() * 10)).charAt(0);		
				if(!answer.contains(item))	
					answer.add(item);

				if (answer.size() == digits) {
					System.out.println("Number has been created");
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	abstract boolean gameEnd() throws IOException;
}

class BaseBallGame extends Game {
	public BaseBallGame(int count){
		super(count);
	}

	public void startGame() throws Exception{
		super.startGame();
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
	public boolean gameEnd() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			Integer.parseInt(input);

			Set<Character> interSection = new HashSet<>(answer);
			interSection.retainAll(input.chars()
					.mapToObj(e->(char)e).collect(Collectors.toSet()));

			int ball = interSection.size();
			int strike = 0;

			System.out.println("answer: " + answer);
			for(int i=0; i<getDifficulty(); i++){
				if(answer.get(i).equals(input.charAt(i))) {
					strike++;
				}
			}
			ball -= strike;

			System.out.println(strike+"S"+" "+ball+"B");

			if(strike == getDifficulty()){
				return true;
			}
		}
		catch (NumberFormatException e){
			System.out.println("The input is not a number. Please check again.");
			setGameCount(getGameCount() + 1);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}
}
//
//class Play {
//	public static void main(String[] args){
//        Game game = new BaseBallGame(5);
//		game.setDifficulty(3);
//		try {
//			game.startGame();
//
//		} catch (Exception e){
//
//			e.printStackTrace();
//		}
//    }
//}
