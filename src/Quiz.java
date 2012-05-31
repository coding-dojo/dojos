import java.util.Date;
import java.util.Random;

public class Quiz {

	static Date d = new Date();
	static Random r = new Random(d.getTime());
	static int rounds = 100;

	public static void main(String[] args) {

		while (true) {
			lazyPlayer();
			smartPlayer();
			moodyPlayer();
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void lazyPlayer() {
		int countWins = 0;

		for (int i = 0; i < rounds; i++) {
			boolean[] doors = createDoors();
			int selected = select();
			if (wonWithoutSelectingNewDoor(doors, selected)) {
				countWins++;
			}
		}

		System.out.println("Lazy: Won " + countWins + " of " + rounds);

	}

	public static void smartPlayer() {
		int countWins = 0;

		for (int i = 0; i < rounds; i++) {

			boolean[] doors = createDoors();
			int selected = select();
			if (wonWhileSelectingNewDoor(doors, selected)) {
				countWins++;
			}
		}

		System.out.println("Smart: Won " + countWins + " of " + rounds);

	}

	public static void moodyPlayer() {
		int countWins = 0;

		for (int i = 0; i < rounds; i++) {

			boolean[] doors = createDoors();
			int selected = select();
			int doChange = random(2); // 0 = not changing
			if (doChange == 1) {
				if (wonWhileSelectingNewDoor(doors, selected)) {
					countWins++;
				}
			} else {
				if (wonWithoutSelectingNewDoor(doors, selected)) {
					countWins++;
				}
			}
		}

		System.out.println("Moody: Won " + countWins + " of " + rounds);

	}

	public static boolean[] createDoors() {
		boolean[] doors = new boolean[] { false, false, false };
		int x = random(3);
		doors[x] = true;
		return doors;
	}

	public static boolean wonWithoutSelectingNewDoor(boolean[] doors, int selected) {
		return doors[selected];
	}

	public static boolean wonWhileSelectingNewDoor(boolean[] doors, int selected) {
		return !doors[selected];
	}

	public static int select() {
		return random(3);
	}

	public static int random(int i) {
		return r.nextInt(i);
	}

}
