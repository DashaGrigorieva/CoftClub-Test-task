package chance;

import hero.Hero;

import java.io.Serializable;

/**
 * Created by User on 11.12.2015.
 */
public class Chance implements Serializable{

    private boolean exist = false;

    /**
     * Create Chance.
     */
    public Chance() {}

    /**
     * Chance allow hero not to fight with monster if hero level >= 3.
     */
    public boolean useChance(Hero hero) {
        return hero.getHeroLevel() < 3 ? false : true;
    }

    /**
     * Take or use chance.
     */
    public void switchChance() {
        if(exist)
            exist = false;
        else
            exist = true;
    }

    /**
     * Is chance exist.
     */
    public boolean isExist() {
        return exist ? true : false;
    }

    /**
     * New string output for Chance.
     */
    @Override
    public String toString() {
        return exist ? "yes" : "no";
    }
}
