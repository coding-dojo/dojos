package de.quizmaster;

import de.quizmaster.QuizMaster.OpenedGame;


public class Player {

    private final boolean alwaysKeeps;

    private int wins = 0;

    private Player(boolean alwaysKeeps) {
        this.alwaysKeeps = alwaysKeeps;
    }

    public static Player keeper() {
        return new Player(true);
    }

    public static Player changer() {
        return new Player(false);
    }

    public void play(int times) {
        for (int i = 0; i < times; i++) {
            OpenedGame choosen = QuizMaster.newGame().choose(1);
            boolean won = alwaysKeeps ? choosen.keepDecision() : choosen.changeDecision();
            if (won) {
                wins++;
            }
        }

    }

    public int show() {
        return wins;
    }

}
