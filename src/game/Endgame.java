package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Endgame {

    public String endgame() {
        World w = new World();
        w.loadMap();
        w.loadCurrentRoom();
        if(w.getcurrentRoom().getId()==8) {

            try(BufferedReader br = new BufferedReader(new FileReader("src/game/dialogues/endgame_dialogue"))) {
                String line;
                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return "";

    }


}
