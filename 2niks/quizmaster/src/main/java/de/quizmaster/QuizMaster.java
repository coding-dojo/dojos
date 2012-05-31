package de.quizmaster;

public class QuizMaster {

    public static class OpenedGame {

        private final NewGame newGame;
        private final int chosenDoor;

        public OpenedGame(NewGame newGame, int chosenDoor) {
            this.newGame = newGame;
            this.chosenDoor = chosenDoor;
        }

        /**
         * Returns <code>true</code> if won, <code>false</code> otherwise.
         * 
         * @return
         */
        public boolean keepDecision() {
            return chosenDoor == newGame.doorWithPrice;
        }

        public boolean changeDecision() {
            return !keepDecision();
        }

        public int showZonkDoor() {
            return newGame.doorDecision.chooseDoor(chosenDoor, newGame.doorWithPrice);
        }

    }

    public static class NewGame {

        private final int doorWithPrice;
        private final DoorDecision doorDecision;

        public NewGame(int doorWithPrice, DoorDecision doorDecision) {
            this.doorWithPrice = doorWithPrice;
            this.doorDecision = doorDecision;
        }

        public OpenedGame choose(int door) {
            return new OpenedGame(this, door);
        }

    }

    public static NewGame newGame(int doorWithPrice, DoorDecision doorDecision) {
        return new NewGame(doorWithPrice, doorDecision);
    }

    public static NewGame newGame() {
        return newGame((int) (Math.random() * 3), new DoorDecision());
    }

}
