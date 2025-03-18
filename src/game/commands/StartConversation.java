package game.commands;

import game.World;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StartConversation extends Command{
    @Override
    public String execute() {

        World w = new World();
        w.loadMap();
        w.loadCurrentRoom();
        String text;

        try (BufferedReader br = new BufferedReader(new FileReader(w.getPersons().get(w.getcurrentRoom().getId()).getDialoguePath())))  {
            while ((text = br.readLine()) != null) {
                text += br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
