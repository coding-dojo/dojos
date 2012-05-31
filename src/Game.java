import java.util.Random;

public class Game {

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public static boolean playTheGame(int gesetzt, boolean twoTimes,
			boolean withOpenDoor) {

		boolean toReturn = false;
		Random random = new Random();
		int treffer = 0;

		treffer = random.nextInt(3);

		if (treffer == gesetzt) {

			toReturn = true;
		}

		if (twoTimes && withOpenDoor) {

			if (toReturn) {

				toReturn = false;
			} else {

				toReturn = true;
			}
		}
		
		

		return toReturn;

	}
}
