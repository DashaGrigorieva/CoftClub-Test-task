package floor;

import hero.Hero;
import artefact.ExpBox;
import artefact.HealthBox;
import artefact.HitBox;
import monster.Monster;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by User on 11.12.2015.
 */
public class Floor implements Serializable{

    private final Monster monster;
    private boolean isFight = false;
    private boolean isTakePrize = false;

    private final Random random = new Random();

    /**
     * Create Floor with monster.
     */
    public Floor(int floorNumber) {
        monster = new Monster(floorNumber);
    }

    public Monster getMonster() { return monster; }

    /**
     * Fight between monster and hero.
     * Return true if hero won.
     */
    public boolean fight(Hero hero) throws InterruptedException {
        if (!isFight) {
            isFight = true;
            System.out.println("Fight : " + hero.getHeroName() + " vs " + monster.getMonsterName());
            int countExp = 0;

            while (hero.isHeroAlive()) {
                hero.heroHitAction(monster);
                Thread.sleep(1000);
                countExp++;
                System.out.println(hero.getHeroName() + " makes damage -" + hero.getHeroHit());
                if (!monster.isMonsterAlive()) {
                    hero.upExp(countExp);
                    System.out.println("Yippee! You are winner! \n" + hero.getHeroName() + " experience +" + countExp);
                    return true;
                }
                monster.monsterHitAction(hero);
                Thread.sleep(1000);
                System.out.println(monster.getMonsterName() + " makes damage -" + monster.getMonsterHit());
            }
            System.out.println("Hero died. GAME OVER. Try again!");
            return false;
        }
        else {
            System.out.println("You have already won monster on this floor!");
            return true;
        }

    }

    /**
     * Prise for hero.
     */
    public void floorPrize(Hero hero) throws InterruptedException {
        if (isFight) {

            if (!isTakePrize) {
                isTakePrize = true;
                System.out.println("You won the fight with monster! So you can get a prize!\n" +
                        "Waiting for generation of magic...");

                int switcher = random.nextInt(4) + 1;

                Thread.sleep(1000);
                System.out.println("Kreks!");
                Thread.sleep(1000);
                System.out.println("Peks!");
                Thread.sleep(1000);
                System.out.println("Feks!");
                Thread.sleep(1000);
                System.out.println("Abracadabra!");
                Thread.sleep(1000);

                switch (switcher) {
                    case 1:
                        ExpBox expBox = new ExpBox();
                        expBox.action(hero);
                        System.out.println(expBox);
                        break;
                    case 2:
                        HealthBox healthBox = new HealthBox();
                        healthBox.action(hero);
                        System.out.println(healthBox);
                        break;
                    case 3:
                        HitBox hitBox = new HitBox();
                        hitBox.action(hero);
                        System.out.println(hitBox);
                        break;
                    case 4:
                        hero.getChance().switchChance();
                        System.out.println("You have a Chance to skip the fight with monster.\n" +
                                "Use it if monster is stronger than you.");
                        break;
                }
            }
            else
                System.out.println("You have already taken prize on this floor!");

        }
        else
            System.out.println("First you need fight with the monster!");
    }

    /**
     * Use Chance to fight  monster.
     */
    public void takeChance(Hero hero) {
        if (!(hero.getChance().isExist())) {
            System.out.println("You don't have a Chance yet!");
            return;
        }

        if (hero.getChance().useChance(hero)) {
            System.out.println("Sorry, but you can use Chance only from 3 level.");
            return;
        }

        if (!isFight) {
            isFight = true;
            hero.getChance().switchChance();
            System.out.println("You won monster" + monster.getMonsterName());
            int countExp = monster.getMonsterHealth() / hero.getHeroHit();
            hero.upExp(countExp);
            System.out.println(hero.getHeroName() + " experience +" + countExp);
        }
        else
            System.out.println("You have already won monster on this floor!Use Chance later.");
    }

    /**
     * Go to next floor.
     */
    public boolean nextFloor(Hero hero) {
        if(!isFight) {
            System.out.println("Stairs to the next floor is blocked by monster!");
            return false;
        }
        else {
            System.out.println("Go to next floor...");
            return true;
        }
    }

}

