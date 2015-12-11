package hero;

import chance.Chance;
import monster.Monster;

import java.io.Serializable;

/**
 * Created by User on 10.12.2015.
 */
public class Hero implements Serializable{

    private String heroName = "NONAME";
    private int heroLevel = 0;
    private int heroExp = 0;
    private int heroHealth = 100;
    private int heroHit = 10;
    private Chance chance;

    /**
     * Create hero.
     */
    public Hero(String heroName) {
        this.heroName = heroName;
        chance = new Chance();
    }

    public String getHeroName() {return  heroName;}
    public int getHeroLevel() { return heroLevel;}
    public int getHeroHit() { return heroHit; }
    public Chance getChance() { return chance; }

    private void nextLevel(){
        heroLevel++;
        heroHealth = 100 + 10*heroLevel;
        heroHit = heroHit + (int)(0.1*heroLevel*heroHit);
    }

    /**
     * Increase hero experience.
     * 10 experience = 1 level.
     */
    public void upExp(int newExp) {
        heroExp += newExp;
        if (heroExp >= 10) {
            heroExp -= 10;
            nextLevel();
        }
    }

    /**
     * Decrease hero health.
     */
    public void downHealth(int downHealth) {
        heroHealth -= downHealth;
    }

    /**
     * Increase hero health.
     */
    public void upHealth(int upHealth) {
        heroHealth += upHealth;
    }

    /**
     * Increase hero hit.
     */
    public void upHit(int upHit) {
        heroHit += upHit;
    }

    /**
     * Hero alive - true.
     */
    public boolean isHeroAlive() {
        return heroHealth <= 0 ? false : true;
    }

    /**
     * Hero hits the monster.
     */
    public void heroHitAction(Monster monster) {
        monster.downHealth(heroHit);
    }

    /**
     * New string output for Hero.
     */
    @Override
    public String toString() {
        return  heroName + " : \n" +
                "   level : " + heroLevel + "\n" +
                "   experience : " + heroExp + "\n" +
                "   health : " + heroHealth + "\n" +
                "   attack : " + heroHit + "\n" +
                "   chance : " + chance + "\n";
    }

}
