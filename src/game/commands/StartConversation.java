package game.commands;

import game.Person;
import game.World;

import java.io.*;
//V teto tride se resi spusteni dialogu.
public class StartConversation extends Command {

    //Tato metoda spusti priklad, ktery vypise dialog dostupny v dane mistnosti.
    @Override
    public String execute() {

        World w = new World();
        w.loadMap();
        w.loadCurrentRoom();
        w.loadPersons();
        if(w.getcurrentRoom().getId()!=1) {

            Person currentPerson = w.getPersons().get(w.getcurrentRoom().getId());


            File dialogueFile = new File(currentPerson.getDialoguePath());


            StringBuilder dialogue = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(dialogueFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    dialogue.append(line).append("\n");
                }
            } catch (IOException e) {
                return "Chyba při čtení souboru: " + e.getMessage();
            }

            return dialogue.toString().trim();
        }else{
            return "V teto mistnosti si nelze s nikym popovidat";
        }

    }


    @Override
    public boolean exit() {
        return false;
    }
}
