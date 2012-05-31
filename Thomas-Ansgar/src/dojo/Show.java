package dojo;

import java.util.ArrayList;
import java.util.Random;

public class Show {
	
	static Random r = new Random(System.currentTimeMillis());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("lazy");
		play(getLazyPlayer());
		System.out.println("smart");
		play(getSmartPlayer());
	}
	
	private static void play(Player player) {

		int wins = 0;
		for (int i = 0; i<1000; i++) {
			Game game=new Game(5, 1);
			
			ArrayList<Gate> gates = game.getGates();
			
			Gate choose = player.choose(gates);
			Gate change = player.change(gates, choose);
			
			if (change.isContent()) {
				wins ++;
			}
		}
		
		System.out.println(wins);
		
	}

	public static Player getLazyPlayer() {
		Player lazyPlayer = new Player() {
			@Override
			public Gate choose(ArrayList<Gate> gates) {
				Gate selectedGate = gates.get(random(gates.size()));
				setSelectedGate(selectedGate);
				return selectedGate;
			}
			
			@Override
			public Gate change(ArrayList<Gate> gates, Gate current) {
				return current;
			}
		};
		
		return lazyPlayer;
	}

	public static Player getSmartPlayer() {
		Player smartPlayer = new Player() {
			@Override
			public Gate choose(ArrayList<Gate> gates) {
				Gate selectedGate = gates.get(random(gates.size()));
				setSelectedGate(selectedGate);
				return selectedGate;
			}
			
			@Override
			public Gate change(ArrayList<Gate> gates, Gate current) {
				gates.remove(current);
				for (Gate gate : gates) {
					if (!gate.isContent()) {
						gates.remove(gate);
						break;
					}
				}
				Gate selectedGate = gates.get(random(gates.size()));
				return selectedGate;
			}
		};
		
		return smartPlayer;
	}

	public static int random(int i) {
		return r.nextInt(i);
	}


}
