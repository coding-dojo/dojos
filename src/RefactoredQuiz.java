import java.util.Date;
import java.util.Random;


public class RefactoredQuiz {

    interface Player {
        boolean redecide();
    }

    static class LazyPlayer implements Player {

        @Override
        public boolean redecide() {
            return false;
        }

    }

    static class SmartPlayer implements Player {

        @Override
        public boolean redecide() {
            return true;
        }

    }

    static class MoodyPlayer implements Player {

        @Override
        public boolean redecide() {
            return random(2) == 0;
        }

    }

    static Date d = new Date();
    static Random r = new Random(d.getTime());
    static int rounds = 100;

    public static void main(String[] args) {
        play(new LazyPlayer());
        play(new SmartPlayer());
        play(new MoodyPlayer());
    }

    public static void play(Player player) {
        int countWins = 0;

        for (int i = 0; i < rounds; i++) {
            boolean[] doors = createDoors();
            int selected = select();

            if (player.redecide()) {
                if (wonWhileSelectingNewDoor(doors, selected)) {
                    countWins++;
                }
            } else {
                if (wonWithoutSelectingNewDoor(doors, selected)) {
                    countWins++;
                }
            }
        }

        System.out.println(String.format("%s: Won %s of " + rounds, player.getClass().getSimpleName(), countWins));
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
