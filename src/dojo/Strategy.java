package dojo;

import java.util.ArrayList;

public interface Strategy {
	/**
	 * Define which gate should be choosen the first time the moderator asks you
	 * 
	 * @param gates
	 * @return
	 */
	public Gate choose(ArrayList<Gate> gates);
	
	/**
	 * Define the gate you want to change too. Might be the same if you do not want to change. 
	 * 
	 * @param gates
	 * @param current
	 * @return
	 */
	public Gate change(ArrayList<Gate> gates, Gate current);

}
