package game.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//Trida resici prikaz na pomoc uzivateli.
public class Help extends Command{
    //Metoda, ktera uzivateli vypise legendu prikazu.
    @Override
    public String execute() {

        try (BufferedReader br = new BufferedReader(new FileReader("src/game/help"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
