package artefact;

import hero.Hero;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by User on 10.12.2015.
 */
public class HealthBox implements Artefact , Serializable {

    private final int upHealth;

    /**
     * Create HitBox.
     */
    public HealthBox() {
        Random random = new Random();
        upHealth = random.nextInt(10) + 1;
    }

    /**
     * Increase hero health using HealthBox.
     */
    @Override
    public void action(Hero hero) {
        hero.upHealth(upHealth);
    }

    /**
     * New string output for HealthBox.
     */
    @Override
    public String toString() {
        return "Magic Box! Health : +" + upHealth;
    }
}
