package artefact;

import hero.Hero;

import java.io.Serializable;

/**
 * Created by User on 10.12.2015.
 */
interface Artefact extends Serializable{

    void action(Hero hero);

}
