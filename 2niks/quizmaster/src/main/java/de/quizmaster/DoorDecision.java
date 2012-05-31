package de.quizmaster;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;


public class DoorDecision {

    public int chooseDoor(int doorChosenByPlayer, int doorWithPrice) {
        Set<Integer> doors = newHashSet(0, 1, 2);
        doors.remove(doorChosenByPlayer);
        doors.remove(doorWithPrice);
        return doors.iterator().next();
    }

}
