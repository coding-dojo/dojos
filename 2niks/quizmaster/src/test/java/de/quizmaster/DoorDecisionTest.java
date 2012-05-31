package de.quizmaster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


public class DoorDecisionTest {

    @Test
    public void chosenDoorEqualsWinDoor_returnsNotTheSameDoor() throws Exception {
        DoorDecision decision = new DoorDecision();

        int chooseDoor = decision.chooseDoor(0, 0);

        assertFalse(0 == chooseDoor);
    }

    @Test
    public void chosenDoorNotEqualsWinDoor_returnsDoorWhichIsLeft() throws Exception {
        DoorDecision decision = new DoorDecision();

        int chooseDoor = decision.chooseDoor(1, 0);
        assertEquals(2, chooseDoor);
        chooseDoor = decision.chooseDoor(0, 1);
        assertEquals(2, chooseDoor);
        chooseDoor = decision.chooseDoor(1, 2);
        assertEquals(0, chooseDoor);
        chooseDoor = decision.chooseDoor(2, 0);
        assertEquals(1, chooseDoor);
        chooseDoor = decision.chooseDoor(2, 1);
        assertEquals(0, chooseDoor);
    }

}
