package de.quizmaster;

import java.util.Random;


public class UniversalZonk {

    private static final int ITERATIONS = 10000;
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        int keeperWins = 0;
        int redeciderWins = 0;
        int randomlySwitchingWins = 0;
        int alwaysSwitchingWins = 0;
        boolean alwaysSwitcherNextDecision = false;
        for (int i = 0; i < ITERATIONS; i++) {
            if (nextRound(false, false, 3)) {
                keeperWins++;
            }
            if (nextRound(false, true, 3)) {
                redeciderWins++;
            }
            if (nextRound(false, RANDOM.nextBoolean(), 3)) {
                randomlySwitchingWins++;
            }
            if (nextRound(false, alwaysSwitcherNextDecision, 3)) {
                alwaysSwitchingWins++;
                alwaysSwitcherNextDecision = !alwaysSwitcherNextDecision;
            }
        }
        printResult("allways keeping first decision", keeperWins);
        printResult("never keeping first decision", redeciderWins);
        printResult("randomly changing or keeping first decision", randomlySwitchingWins);
        printResult("as often changing as keeping first decision", alwaysSwitchingWins);

    }

    static boolean nextRound(boolean alreadyWon, boolean redecide, int noOfDoors) {

        if (!alreadyWon) {
            alreadyWon = new Random(System.currentTimeMillis()).nextInt(noOfDoors) == 0;
        }

        if (!redecide) {
            return alreadyWon;
        }

        if (alreadyWon && noOfDoors > 2) {
            return false;
        }

        if (noOfDoors == 1) {
            return alreadyWon;
        }

        return nextRound(alreadyWon, redecide, noOfDoors - 1);
    }

    private static void printResult(String player, int noOfWins) {
        System.out.println(String.format("%s: won: %s, lost: %s", player, noOfWins, ITERATIONS - noOfWins));
    }
}
