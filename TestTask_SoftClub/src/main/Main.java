package main;

import game.Game;

import java.io.*;

/**
 * Created by User on 11.12.2015.
 */
@SuppressWarnings("ALL")
class Main {

    private static final File saveFile = new File("save.out");
    private static Game game;

    private static void saveInFile() throws IOException {
        FileOutputStream fos = new FileOutputStream(saveFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(game);
        oos.flush();
        oos.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        if (saveFile.exists()) {
            System.out.println("\n 1 : Start new game.\n" +
                    " 2 : Continue last game\n");
            String switcher = bufferedReader.readLine();
            switch (switcher) {
                case "1":
                    saveFile.delete();
                    game = new Game();
                    if(game.startGame()) {
                        saveInFile();
                    }
                    else
                        saveFile.delete();
                    break;
                case "2":
                    FileInputStream fis = new FileInputStream(saveFile);
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    game = (Game)oin.readObject();
                    fis.close();
                    oin.close();
                    if(game.startGame()) {
                        saveFile.delete();
                        saveInFile();
                    }
                    else
                        saveFile.delete();
                    break;
                default:
                    System.out.println("Wrong symbol!");
            }
        }
        else {
            game = new Game();
            if(game.startGame()) {
                saveInFile();
            }
            else
                saveFile.delete();
        }

    }

}
