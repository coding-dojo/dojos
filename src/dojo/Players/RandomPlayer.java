package dojo.Players;

import java.util.ArrayList;
import java.util.Random;

import dojo.Gate;
import dojo.Player;

public class RandomPlayer extends Player {

	@Override
	public int choose(int numberOfGates) {
		Random r = new Random();
		return r.nextInt(numberOfGates);
	}

	@Override
	public int change(int numberOfGates, int current) {
		Random r = new Random();
		return r.nextInt(numberOfGates);
	}

}
