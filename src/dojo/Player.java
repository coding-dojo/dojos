package dojo;

import java.util.ArrayList;

public abstract class Player implements Strategy {

	private int selectedGate;

	public int getSelectedGate() {
		return selectedGate;
	}

	public void setSelectedGate(int selectedGate) {
		this.selectedGate = selectedGate;
	}
	
}
