package dojo;

import java.util.Random;

public class Gate {
	
	// true if price inside; false if not. 
	private boolean content;
	private Random randomChooser;
	
	public Gate() {
		this.content = randomChooser.nextBoolean();
	}
	
	public Gate(boolean isWinningGate) {
		this.content = isWinningGate;
	}

	public boolean isContent() {
		return content;
	}

	public void setContent(boolean content) {
		this.content = content;
	}
	
	

}
