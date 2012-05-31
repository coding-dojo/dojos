package de.quizmaster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.quizmaster.QuizMaster.NewGame;
import de.quizmaster.QuizMaster.OpenedGame;


@RunWith(MockitoJUnitRunner.class)
public class QuizMasterTest {

    @Mock
    DoorDecision doorDecision;

    @Test
    public void playerChoosesDoorWithPrice_gameMasterOpensDoorWithZonk() throws Exception {
        int doorChosenByPlayer = 0;
        int doorWithPrice = 0;
        when(doorDecision.chooseDoor(doorChosenByPlayer, doorWithPrice)).thenReturn(1);

        NewGame newGame = QuizMaster.newGame(doorWithPrice, doorDecision);
        OpenedGame openedGame = newGame.choose(0);
        int zonkDoor = openedGame.showZonkDoor();
        assertEquals(1, zonkDoor);
    }

    @Test
    public void playerChoosesDoorWithoutPrice_gameMasterOpensDoorWithZonk() throws Exception {
        int doorChosenByPlayer = 0;
        int doorWithPrice = 1;
        when(doorDecision.chooseDoor(doorChosenByPlayer, doorWithPrice)).thenReturn(2);

        NewGame newGame = QuizMaster.newGame(doorWithPrice, doorDecision);
        OpenedGame openedGame = newGame.choose(0);
        int zonkDoor = openedGame.showZonkDoor();
        assertEquals(2, zonkDoor);
    }

    @Test
    public void playerChoosesDoorWithPrice_andKeepsDecision_playerWins() throws Exception {
        int doorChosenByPlayer = 0;
        int doorWithPrice = 0;
        when(doorDecision.chooseDoor(doorChosenByPlayer, doorWithPrice)).thenReturn(1);

        NewGame newGame = QuizMaster.newGame(doorWithPrice, doorDecision);
        OpenedGame openedGame = newGame.choose(0);
        boolean won = openedGame.keepDecision();

        assertTrue(won);
    }

    @Test
    public void playerChoosesDoorWithZonk_andKeepsDecision_playerLoses() throws Exception {
        int doorChosenByPlayer = 0;
        int doorWithPrice = 1;
        when(doorDecision.chooseDoor(doorChosenByPlayer, doorWithPrice)).thenReturn(2);

        NewGame newGame = QuizMaster.newGame(doorWithPrice, doorDecision);
        OpenedGame openedGame = newGame.choose(0);
        boolean won = openedGame.keepDecision();

        assertFalse(won);
    }

    @Test
    public void playerChoosesDoorWithPrice_andChangesDecision_playerLoses() throws Exception {
        int doorChosenByPlayer = 0;
        int doorWithPrice = 0;
        when(doorDecision.chooseDoor(doorChosenByPlayer, doorWithPrice)).thenReturn(1);

        NewGame newGame = QuizMaster.newGame(doorWithPrice, doorDecision);
        OpenedGame openedGame = newGame.choose(0);
        boolean won = openedGame.changeDecision();

        assertFalse(won);
    }

    @Test
    public void playerChoosesDoorWithZonk_andChangesDecision_playerWins() throws Exception {
        int doorChosenByPlayer = 0;
        int doorWithPrice = 1;
        when(doorDecision.chooseDoor(doorChosenByPlayer, doorWithPrice)).thenReturn(2);

        NewGame newGame = QuizMaster.newGame(doorWithPrice, doorDecision);
        OpenedGame openedGame = newGame.choose(0);
        boolean won = openedGame.changeDecision();

        assertTrue(won);
    }

}
