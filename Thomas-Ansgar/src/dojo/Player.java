package dojo;


public abstract class Player implements Strategy {

	private Gate selectedGate;

	public Gate getSelectedGate() {
		return selectedGate;
	}

	public void setSelectedGate(Gate selectedGate) {
		this.selectedGate = selectedGate;
	}
	
}
