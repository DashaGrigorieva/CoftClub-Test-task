package artefact;

import hero.Hero;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by User on 10.12.2015.
 */
public class HitBox implements Artefact , Serializable{

    private final int upHit;

    /**
     * Create HitBox.
     */
    public HitBox() {
        Random random = new Random();
        upHit = random.nextInt(10)+1;
    }

    /**
     * Increase hero manna using HitBox.
     */
    @Override
    public void action(Hero hero) {
        hero.upHit(upHit);
    }

    /**
     * New string output for HitBox.
     */
    @Override
    public String toString() {
        return "Magic Box! Attack : +" + upHit;
    }

}
