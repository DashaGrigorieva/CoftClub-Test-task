package game;

import floor.Floor;
import hero.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * Created by User on 11.12.2015.
 */
public class Game implements Serializable {

    private int floorNum = 0;
    private Hero hero;

    /**
     * Create game.
     */
    public Game() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hi! Write your name... ");
        String name = bufferedReader.readLine();
        hero = new Hero(name);

        System.out.println("\nWELCOME, " + hero.getHeroName() + "!\n" +
                "You're on the floor #" + (floorNum + 1) + "There are 10 floors in Magic Tower. \n" +
                "On the roof you find Dream Of Your Heart! Go!\n" +
                "...stop, elevator doesn't work.\n" +
                "You need to go on your foot - it's dangerous!\n" +
                "I'm waiting you on the roof! Good luck!\n");

    }

    /**
     * Gameplay.
     */
    public boolean startGame() throws IOException, InterruptedException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for(int i = floorNum; i < 10; i++) {
            System.out.println(hero);

            Floor floor = new Floor(i + 1);
            System.out.println("You're on the floor #" + (i + 1) + ". \n" +
                    "And you are not alone...\n");

            System.out.println(floor.getMonster());
            System.out.println(" Choose...");

            String switcher = "10";

            while (switcher != "0") {

                System.out.println("\n 1 : Fight with the monster\n" +
                        " 2 : Get prize\n" +
                        " 3 : Use Chance\n" +
                        " 4 : Go to next floor\n" +
                        " 5 : Hero description\n" +
                        " 6 : Save and go out\n");

                switcher = bufferedReader.readLine();

                switch (switcher) {
                    case "1":
                        if (!floor.fight(hero))
                            return false;
                        break;
                    case "2":
                        floor.floorPrize(hero);
                        break;
                    case "3":
                        floor.takeChance(hero);
                        break;
                    case "4":
                        if(floor.nextFloor(hero))
                            switcher = "0";
                        break;
                    case "5":
                        System.out.print(hero);
                        break;
                    case "6":
                        return true;
                    default:
                        System.out.print("Wrong choice! Try again!");
                }
            }
            floorNum++;
        }
        System.out.println("Congratulations! You're on the top of Magic Tower!");
        return false;
    }

}
