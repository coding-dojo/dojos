package dojo;

import java.util.ArrayList;
import java.util.Random;

public class Game {

	private ArrayList<Gate> gates;
	private int numberOfWinningGates;
	
	public Game(int numberOfGates, int numberOfWinningGates) {
		
		this.gates = new ArrayList<Gate>();
		this.numberOfWinningGates = numberOfWinningGates;
		
		setupGates(numberOfGates, numberOfWinningGates);
		
	}

	public void setupGates(int numberOfGates, int numberOfWinningGates) {
		createFalseGates(numberOfGates);
		setWinningGates(numberOfGates, numberOfWinningGates);
	}

	private void createFalseGates(int numberOfGates) {
		for( int i = 0; i <= numberOfGates; i++ ) {
			Gate currentGate = new Gate(false);
			gates.add(currentGate);
		}
	}

	private void setWinningGates(int numberOfGates, int numberOfWinningGates) {
		for ( int j = 0; j <= numberOfWinningGates; j++ ) {
			int potentialGate = chooseGate(numberOfGates);
			
			while( Boolean.TRUE.equals(gates.get(potentialGate).isContent())) {
				potentialGate = chooseGate(numberOfGates);
			}
			
			gates.get(potentialGate).setContent(true);
		}
	}

	private int chooseGate(int numberOfGates) {
		
		Random r = new Random();
		int potentialGate = r.nextInt(numberOfGates);
		return potentialGate;
		
	}
	
	
	
}
