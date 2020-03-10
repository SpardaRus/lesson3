package com.lesson4.zombie;

public class Zombie {

    private int health = 2;
    private int distanceToHero;

    public Zombie(int distanceToHero) {
        this.distanceToHero = distanceToHero;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDistanceToHero() {
        return distanceToHero;
    }

    public void setDistanceToHero(int distanceToHero) {
        this.distanceToHero = distanceToHero;
    }

}
