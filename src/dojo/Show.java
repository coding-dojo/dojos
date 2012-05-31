package dojo;

import java.util.ArrayList;

import dojo.Players.RandomPlayer;
import dojo.Players.StandingPlayer;

public class Show {
	
	private final static int NUMBER_OF_TOTAL_GAMES = 1000;
	private final static int NUMBER_OF_GATES = 3;
	private final static int NUMBER_OF_WINNING_GATES = 1;
	
	
	private ArrayList<Gate> gatesInGame;
	
	public static Player randomPlayer = new RandomPlayer();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int won = 0;
		int lost = 0;
		
		for( int i = 0; i<= NUMBER_OF_TOTAL_GAMES; i++) {
			
			Game currentGame = new Game(NUMBER_OF_GATES, NUMBER_OF_WINNING_GATES);
			
			int firstRandomSelection = randomPlayer.choose(NUMBER_OF_GATES);
			int changedRandomSelection = randomPlayer.change(NUMBER_OF_GATES, firstRandomSelection);
			
			if( Boolean.TRUE.equals(currentGame.getGates().get(changedRandomSelection))) {
				won++;
			} else {
				lost++;
			}
		}
		
		System.out.println("WON: " + won);
		System.out.println("LOST: " + lost);

	}

}
