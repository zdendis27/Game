package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExtraDialoguesLoad {
    private ArrayList<ExtraDialogue> dialogues = new ArrayList<>();

    public ArrayList<ExtraDialogue> getDialogues() {
        return dialogues;
    }

    public void setDialogues(ArrayList<ExtraDialogue> dialogues) {
        this.dialogues = dialogues;
    }

    public boolean load() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/game/extradialogues"))){
            String line;

            while((line = br.readLine())!=null){

                String[] parts = line.split(";");
                ExtraDialogue extraDialogue = new ExtraDialogue(Integer.parseInt(parts[0]), parts[1], parts[2]);
                dialogues.add(extraDialogue);
            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


}
