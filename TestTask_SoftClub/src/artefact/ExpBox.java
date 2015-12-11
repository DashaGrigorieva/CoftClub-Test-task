package artefact;

import hero.Hero;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by User on 10.12.2015.
 */
public class ExpBox implements Artefact , Serializable{

    private final int upExp;

    /**
     * Create ExpBox.
     */
    public ExpBox() {
        Random random = new Random();
        upExp = random.nextInt(5) + 1;
    }

    /**
     * Increase hero experience using ExpBox.
     */
    @Override
    public void action(Hero hero) {
        hero.upExp(upExp);
    }

    /**
     * New string output for MannaBox.
     */
    @Override
    public String toString() {
        return " Magic Box! Experience : +" + upExp;
    }

}
