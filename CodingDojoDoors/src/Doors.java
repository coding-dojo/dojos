import java.util.Date;
import java.util.Random;

public class Doors {

	static Date d = new Date();
	static Random r = new Random(d.getTime() + 321321);
	static int rounds = 100;

	static int countDoors = 3;

	public static void main(String[] args) {

		while (true) {
			playWithMe(new LazyPlayer());
			playWithMe(new SmartPlayer());
			playWithMe(new MoodyPlayer());
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	
	}

	public static void playWithMe(Player player) {

		int countWins = 0;

		for (int i = 0; i < rounds; i++) {

			Boolean[] doors = createDoors();
			int selected = player.selectDoor();

			if (selected < 0 || selected > (countDoors - 1)) {
				throw new IllegalArgumentException("Selected door must be 0<=selected<=" + (countDoors - 1) + ", got ["
						+ selected + "]");
			}

			if ((doors[selected] ^ player.switchDoor())) {
				countWins++;
			}
		}

		System.out.println(player.getName() + ": Won " + countWins + " of " + rounds);

	}

	public static Boolean[] createDoors() {
		Boolean[] doors = new Boolean[countDoors];
		for (int i = 0; i < doors.length; i++) {
			doors[i] = false;
		}
		int x = random(countDoors);
		doors[x] = true;
		return doors;
	}

	private static int random(int i) {
		return r.nextInt(i);
	}

}