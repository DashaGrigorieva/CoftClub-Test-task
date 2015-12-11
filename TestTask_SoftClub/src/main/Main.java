package main;

import game.Game;

import java.io.*;

/**
 * Created by User on 11.12.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        File saveFile = new File("save.out");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Game game;

        if (saveFile.exists()) {
            System.out.println("\n 1 : Start new game.\n" +
                    " 2 : Continue last game\n");
            String switcher = bufferedReader.readLine();
            switch (switcher) {
                case "1":
                    saveFile.delete();
                    game = new Game();
                    if(game.startGame()) {
                            FileOutputStream fos = new FileOutputStream(saveFile);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(game);
                            oos.flush();
                            oos.close();
                    }
                    else
                    saveFile.delete();
                    break;
                case "2":
                    FileInputStream fis = new FileInputStream(saveFile);
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    game = (Game) oin.readObject();
                    if(game.startGame()) {
                        saveFile.delete();
                        FileOutputStream fos = new FileOutputStream(saveFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(game);
                        oos.flush();
                        oos.close();
                    }
                    else
                    saveFile.delete();
                    break;
                default:
                    System.out.println("Wrong symbol!");
                    return;
            }
        }
        else {
            game = new Game();
            if(game.startGame()) {
                FileOutputStream fos = new FileOutputStream(saveFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(game);
                oos.flush();
                oos.close();
            }
            else
                saveFile.delete();
        }
    }
}
