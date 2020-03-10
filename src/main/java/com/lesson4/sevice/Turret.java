package com.lesson4.sevice;

import com.lesson4.zombie.Zombie;

public class Turret {

    private static final String DONE = "Все зомби мертвы";
    private static final String FAIL = "Потрачено...";

    public String shoot(Zombie[] zombies) {
        String result = DONE;

        while (true) {
            if (isNotAllAlive(zombies)) {
                break;
            }

            result = shootAll(zombies);
            if (isFailShootAll(result)) {
                break;
            }
        }

        return result;
    }

    private boolean isNotAllAlive(Zombie[] zombies) {
        boolean isAllAlive = true;

        for (int i = 0; i < zombies.length; i++) {
            Zombie zombie = zombies[i];
            if (zombie.getHealth() > 0) {
                isAllAlive = false;
            }
        }

        return isAllAlive;
    }

    private String shootAll(Zombie[] zombies) {
        String result = DONE;

        for (int i = 0; i < zombies.length; i++) {
            Zombie zombie = zombies[i];

            if (isNotExistDistance(zombie)) {
                result = FAIL;
                break;
            }

            int health = zombie.getHealth();
            if (isAlive(health)) {
                shoot(zombie);
            }

            distanceReduction(zombies);
        }

        return result;
    }

    private boolean isNotExistDistance(Zombie zombie) {
        int distanceToHero = zombie.getDistanceToHero();
        if (distanceToHero <= 0) {
            return true;
        }
        return false;
    }

    private boolean isAlive(int health) {
        return health > 0;
    }

    private void shoot(Zombie zombie) {
        int health = zombie.getHealth();
        zombie.setHealth(health - 1);
    }

    private void distanceReduction(Zombie[] zombies) {
        for (int i = 0; i < zombies.length; i++) {
            Zombie zombie = zombies[i];
            int distanceToHero = zombie.getDistanceToHero();
            zombie.setDistanceToHero(distanceToHero - 1);
        }
    }

    private boolean isFailShootAll(String resultShootAll) {
        return !DONE.equals(resultShootAll);
    }
}
