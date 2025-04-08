package game;

import java.io.*;
import java.util.ArrayList;

/**
 * Tato trida slouzi k sprave uzivatele
 */

public class User {

    private int reputation;



    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    /**
     * Tato metoda nacte reputaci uzivatele.
     */

    public boolean loadUser(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/game/user"))) {
            String line;
            while ((line = br.readLine()) != null) {
                reputation = Integer.parseInt(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return true;
    }

    /**
     * Tato metoda aktualizuje reputaci uzivatele.
     */

    public boolean updateReputation() {

        try (BufferedReader br = new BufferedReader(new FileReader("src/game/user"))) {
            String line = br.readLine();
            if (line != null) {
                int reputation = Integer.parseInt(line.trim());
                reputation += 2;

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/game/user"))) {
                    bw.write(String.valueOf(reputation));
                    bw.newLine();
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
