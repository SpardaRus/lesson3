package com.lesson4.sevice;


import com.lesson4.zombie.Zombie;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AimingTest {

    private static Aiming aiming;
    private Zombie[] zombies;

    @BeforeClass
    public static void setup() {
        aiming = new Aiming();
    }

    @Before
    public void initZombies() {
        zombies = new Zombie[]{
                new Zombie(20),
                new Zombie(11),
                new Zombie(14),
                new Zombie(41),
                new Zombie(21)
        };
    }

    @Test
    public void sortByDistance() {
        aiming.sortByDistance(zombies);
        int[] expectedDistances = getExpectedSortedDistances();
        for (int i = 0; i < zombies.length; i++) {
            assertEquals(expectedDistances[i], zombies[i].getDistanceToHero());
        }
    }

    private int[] getExpectedSortedDistances() {
        return new int[]{15, 14, 20, 21, 41};
    }

}