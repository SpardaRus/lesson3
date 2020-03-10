package com.lesson4.sevice;

import com.lesson4.zombie.Zombie;

public class Aiming {

    public void sortByDistance(Zombie[] zombies) {
        for (int i = 0; i < zombies.length; i++) {
            for (int j = 0; j < zombies.length-1; j++) {
                if (zombies[j].getDistanceToHero() > zombies[j + 1].getDistanceToHero()) {
                    toSwap(zombies, j, j + 1);
                }
            }
        }
    }

    private void toSwap(Zombie[] sortZombies, int first, int second) {
        Zombie temp = sortZombies[first];
        sortZombies[first] = sortZombies[second];
        sortZombies[second] = temp;
    }

}
