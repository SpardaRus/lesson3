package com.lesson4;

import com.lesson4.sevice.Aiming;
import com.lesson4.sevice.Turret;
import com.lesson4.zombie.Zombie;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        Aiming aiming = new Aiming();
        Zombie[] zombies = new Zombie[]{
                new Zombie(6),
                new Zombie(4),
                new Zombie(5),
        };

        System.out.println();
        System.out.println("Shoot for zombies");
        Turret turret = new Turret();
//        aiming.sortByDistance(zombies);
        String resultShoot = turret.shoot(zombies);
        System.out.println("Result shoot: " + resultShoot);

        System.out.println();
        System.out.println("End");
    }

}
