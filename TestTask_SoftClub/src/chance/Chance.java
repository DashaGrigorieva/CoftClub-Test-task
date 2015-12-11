package chance;

import hero.Hero;

import java.io.Serializable;

/**
 * Created by User on 11.12.2015.
 */
@SuppressWarnings("ALL")
public class Chance implements Serializable{

    private boolean exist = false;

    /**
     * Create Chance.
     */
    public Chance() {}

    /**
     * Chance allow hero not to fight with monster if hero level >= 3.
     */
    @SuppressWarnings("RedundantConditionalExpression")
    public boolean useChance(Hero hero) {
        //noinspection RedundantConditionalExpression
        return hero.getHeroLevel() >= 3;
    }

    /**
     * Take or use chance.
     */
    public void switchChance() {
        exist = !exist;
    }

    /**
     * Is chance exist.
     */
    @SuppressWarnings("RedundantConditionalExpression")
    public boolean isExist() {
        //noinspection RedundantConditionalExpression
        return exist;
    }

    /**
     * New string output for Chance.
     */
    @Override
    public String toString() {
        return exist ? "yes" : "no";
    }
}
