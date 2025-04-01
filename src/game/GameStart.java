package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
//Tato trida se stara o zacatek programu.
public class GameStart {

    private ArrayList<Path> sources = new ArrayList<>();
    private ArrayList<Path> targets = new ArrayList<>();


    //Tato metoda nacte zakladni soubory.
    public boolean setStartingFiles(){
        sources.add(Path.of("src/game/startingFiles/currentLocStart"));
        sources.add(Path.of("src/game/startingFiles/inventoryStart"));
        sources.add(Path.of("src/game/startingFiles/mapaStart"));
        sources.add(Path.of("src/game/startingFiles/personsStart"));
        sources.add(Path.of("src/game/startingFiles/userStart"));
        targets.add(Path.of("src/game/currentLoc"));
        targets.add(Path.of("src/game/inventory"));
        targets.add(Path.of("src/game/mapa"));
        targets.add(Path.of("src/game/person"));
        targets.add(Path.of("src/game/user"));
        try {
            for(int i = 0; i < sources.size(); i++){
                Files.copy(sources.get(i), targets.get(i), StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (Exception e) {
            System.out.println("Chyba při kopírování souboru: " + e.getMessage());
        }

        return false;
    }

    //Tato metoda spusti prolog.
    public boolean prologue(){

        try(BufferedReader br = new BufferedReader(new FileReader("src/game/dialogues/prologue"))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
