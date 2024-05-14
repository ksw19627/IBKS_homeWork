import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

abstract class Game{
	private int gameCount = 5;
	public List<Character> answer;

	public Game(int count){
        setCount(count);
	}

	public void setCount(int count){
        this.gameCount = count;
	}
	public int getGameCount(){return gameCount;}
	public void startGame() throws Exception {
		try {
			answer = new ArrayList<>();
			while(true){
				char item = Integer.toString((int)(Math.random() * 10)).charAt(0);		
				if(!answer.contains(item))	
					answer.add(item);

				if (answer.size() == 3) {
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

	public boolean gameEnd() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			Set<Character> interSection = new HashSet<>(answer);
			interSection.retainAll(input.chars()
					.mapToObj(e->(char)e).collect(Collectors.toSet()));

			int ball = interSection.size();
			int strike = 0;

			System.out.println("answer: " + answer);
			for(int i=0; i<answer.size(); i++){
				if(answer.get(i).equals(input.charAt(i))) {
					strike++;
				}
			}
			ball -= strike;

			System.out.println(strike+"S"+" "+ball+"B");

			if(strike == 3){
				return true;
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}
}

class Play {
	public static void main(String[] args){
        Game game = new BaseBallGame(5);
		try {
			game.startGame();

		}catch (Exception e){
			e.printStackTrace();
		}
    }
}
