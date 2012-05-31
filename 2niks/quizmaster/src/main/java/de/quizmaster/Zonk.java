package de.quizmaster;

import java.util.Random;


public class Zonk {

    private static final int ITERATIONS = 10000;
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int keeperWins = 0;
        int redeciderWins = 0;
        int randomlySwitchingWins = 0;
        int alwaysSwitchingWins = 0;
        boolean alwaysSwitcherNextDecision = false;
        for (int i = 0; i < ITERATIONS; i++) {
            if (pickDoor(false)) {
                keeperWins++;
            }
            if (pickDoor(true)) {
                redeciderWins++;
            }
            if (pickDoor(RANDOM.nextBoolean())) {
                randomlySwitchingWins++;
            }
            if (pickDoor(alwaysSwitcherNextDecision)) {
                alwaysSwitchingWins++;
                alwaysSwitcherNextDecision = !alwaysSwitcherNextDecision;
            }
        }
        printResult("allways keeping first decision", keeperWins);
        printResult("never keeping first decision", redeciderWins);
        printResult("randomly changing or keeping first decision", randomlySwitchingWins);
        printResult("as often changing as keeping first decision", alwaysSwitchingWins);
    }

    public static boolean pickDoor(boolean reconsider) {
        final boolean firstPickIsAWin = RANDOM.nextInt(3) == 0;
        return reconsider ? !firstPickIsAWin : firstPickIsAWin;
    }

    private static void printResult(String player, int noOfWins) {
        System.out.println(String.format("%s: won: %s, lost: %s", player, noOfWins, ITERATIONS - noOfWins));
    }
}