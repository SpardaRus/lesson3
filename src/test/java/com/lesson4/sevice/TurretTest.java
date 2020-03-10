package com.lesson4.sevice;

import com.lesson4.zombie.Zombie;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TurretTest {

    private static final String DONE = "Все зомби мертвы";
    private static final String FAIL = "Потрачено...";

    private static Turret turret;
    private static Aiming aiming;

    private Zombie[] zombies;

    @BeforeClass
    public static void setup() {
        turret = new Turret();
        aiming = new Aiming();
    }

    @Before
    public void initZombies() {
        zombies = new Zombie[]{
                new Zombie(6),
                new Zombie(4),
                new Zombie(5),
        };
    }

    @Test
    public void shootWithoutAim() {
        String resultShoot = turret.shoot(zombies);
        assertEquals(FAIL, resultShoot);
    }

    @Test
    public void shootWithAim() {
        aiming.sortByDistance(zombies);
        String resultShoot = turret.shoot(zombies);
        assertEquals(DONE, resultShoot);
    }
}
