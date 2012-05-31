import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RefactoredQuiz2 {

    interface Player {
        boolean redecide();

        void lost();

        void won();

        int noOfWins();

        int noOfLosses();

    }

    static abstract class WinCountingPlayer implements Player {

        int won = 0;
        int lost = 0;

        @Override
        public void lost() {
            lost++;
        }

        @Override
        public void won() {
            won++;
        }

        @Override
        public int noOfWins() {
            return won;
        }

        @Override
        public int noOfLosses() {
            return lost;
        }

    }

    static class LazyPlayer extends WinCountingPlayer {

        @Override
        public boolean redecide() {
            return false;
        }

    }

    static class SmartPlayer extends WinCountingPlayer {

        @Override
        public boolean redecide() {
            return true;
        }

    }

    static class MoodyPlayer extends WinCountingPlayer {

        @Override
        public boolean redecide() {
            return random(2) == 0;
        }

    }

    static final Random RANDOM = new Random(System.currentTimeMillis());
    static final int ROUNDS = 100;

    private final List<Player> players;

    public RefactoredQuiz2() {
        players = new ArrayList<Player>();
    }

    public void registerPlayer(Player player) {
        this.players.add(player);
    }

    public void startGame() {
        for (Player player : players) {
            play(player);
        }
    }

    public static void main(String[] args) {
        RefactoredQuiz2 quiz = new RefactoredQuiz2();
        quiz.registerPlayer(new LazyPlayer());
        quiz.registerPlayer(new SmartPlayer());
        quiz.registerPlayer(new MoodyPlayer());
        quiz.startGame();

        quiz.result();

    }

    private void result() {
        for (Player player : players) {
            System.out.println(String.format("Player %s: won: %s, lost: %s, total: %s", player.getClass()
                    .getSimpleName(), player.noOfWins(), player.noOfLosses(), player.noOfWins() + player.noOfLosses()));
        }
    }

    public void play(Player player) {
        for (int i = 0; i < ROUNDS; i++) {
            boolean[] doors = createDoors();
            int selected = select();

            if (player.redecide()) {
                if (wonWhileSelectingNewDoor(doors, selected)) {
                    player.won();
                } else {
                    player.lost();
                }
            } else {
                if (wonWithoutSelectingNewDoor(doors, selected)) {
                    player.won();
                } else {
                    player.lost();
                }
            }
        }
    }

    public boolean[] createDoors() {
        boolean[] doors = new boolean[] { false, false, false };
        int x = random(3);
        doors[x] = true;
        return doors;
    }

    public boolean wonWithoutSelectingNewDoor(boolean[] doors, int selected) {
        return doors[selected];
    }

    public boolean wonWhileSelectingNewDoor(boolean[] doors, int selected) {
        return !doors[selected];
    }

    public int select() {
        return random(3);
    }

    public static int random(int i) {
        return RANDOM.nextInt(i);
    }

}
