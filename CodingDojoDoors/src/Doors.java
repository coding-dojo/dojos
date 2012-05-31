import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Doors {

	static Date d = new Date();
	static Random r = new Random(d.getTime());
	static int rounds = 1000;

	static int countDoors=3;
	
	public static void main(String[] args) {

			lazyPlayer();
			smartPlayer();
			moodyPlayer();
	}

	public static void lazyPlayer() {
		int countWins = 0;

		for (int i = 0; i < rounds; i++) {
			Boolean[] doors = createDoors();
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

			Boolean[] doors = createDoors();
			int selected = select();
			if(determineIfSmartPlayerWinByChanging(doors, selected)){
				countWins++;
			}
		}

		System.out.println("Smart: Won " + countWins + " of " + rounds);

	}

	public static void moodyPlayer() {
		int countWins = 0;

		for (int i = 0; i < rounds; i++) {

			Boolean[] doors = createDoors();
			int selected = select();
			int doChange = random(2); // 0 = not changing
			if (doChange == 1) {
				if (determineIfSmartPlayerWinByChanging(doors, selected)) {
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

	public static Boolean[] createDoors() {
		Boolean[] doors = new Boolean[countDoors];
		for (int i = 0; i < doors.length; i++) {
			doors[i]=false;
		}
		int x = random(countDoors);
		doors[x] = true;
		return doors;
	}

	public static Boolean wonWithoutSelectingNewDoor(Boolean[] doors,
			int selected) {
		return doors[selected];
	}
	
	public static Boolean determineIfSmartPlayerWinByChanging(Boolean[] doors, int selected){
		List<Boolean> tueren=new ArrayList<Boolean>(countDoors);
		Collections.addAll(tueren, doors);
		tueren.remove(selected);
		removeDoorWithoutPrice(tueren);
		int secondSelected=random(tueren.size());
		return tueren.get(secondSelected);
	}
	
	public static void removeDoorWithoutPrice(List<Boolean> tueren){
		for (Boolean door : tueren) {
			if(!door){
				tueren.remove(door);
				break;
			}
		}
	}
	
	public static Boolean wonWhileSelectingNewDoor(Boolean[] doors, int selected) {
		return !doors[selected];
	}

	public static int select() {
		return random(countDoors);
	}

	public static int random(int i) {
		return r.nextInt(i);
	}

}