package de.quizmaster;

import org.junit.Test;


public class PlayerTest {

    @Test
    public void keeper() throws Exception {
        Player keeper = Player.keeper();
        keeper.play(1000);
        int gamesWon = keeper.show();
        System.out.println("keeper: " + gamesWon);
    }

    @Test
    public void changer() throws Exception {
        Player changer = Player.changer();
        changer.play(1000);
        int gamesWon = changer.show();
        System.out.println("changer: " + gamesWon);
    }

}
