package monster;

import hero.Hero;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by User on 10.12.2015.
 */
public class Monster implements Serializable{

    private String monsterName = "NONAME";
    private int monsterHit = 10;
    private int monsterHealth = 100;

    private final Random random = new Random();

    public int getMonsterHit() { return monsterHit; }
    public int getMonsterHealth() { return monsterHealth; }
    public String getMonsterName() { return monsterName; }

    private String setMonsterName() {
        int switcherName = random.nextInt(5) + 1;
        int switcherDescription = random.nextInt(5) + 1;
        String name;
        String description;

        switch (switcherName) {
            case 1: name = "Lord Wolan-De-Mort";
                break;
            case 2: name = "Darth Vader";
                break;
            case 3: name = "Megathron";
                break;
            case 4: name = "Freddy Krueger";
                break;
            case 5: name = "Cruella De Vil";
                break;
            default: name = "Monster";
        }

        switch (switcherDescription) {
            case 1:
                description = " purple speckled";
                break;
            case 2:
                description = " great and terrible";
                break;
            case 3:
                description = " in boxers";
                break;
            case 4:
                description = " after morning jogging";
                break;
            case 5:
                description = " hurry to take the child from the kindergarten";
                break;
            default:
                description = " great and terrible";
        }

        return name + description;
    }

    /**
     * Create monster.
     */
    public Monster(int level) {
        monsterName = this.setMonsterName();
        int health = random.nextInt(100) + 15;
        monsterHealth = health + (int)(health*level*0.1);
        int hit = random.nextInt(15) + 1;
        monsterHit = hit + (int)(hit*level*0.1);
    }

    /**
     * Decrease monster health.
     */
    public void downHealth(int downHealth) {
        monsterHealth -= downHealth;
    }

    /**
     * Monster hits the hero.
     */
    public void monsterHitAction(Hero hero) {
        hero.downHealth(monsterHit);
    }

    /**
     * Monster died - true.
     */
    public boolean isMonsterAlive() {
        return monsterHealth > 0;
    }

    /**
     * New string output for Monster.
     */
    @Override
    public String toString() {
        return "Monster " + monsterName + " : \n" +
                "   health : " + monsterHealth + "\n" +
                "   attack : " + monsterHit;
    }
}
