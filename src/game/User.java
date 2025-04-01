package game;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
//Tato trida slouzi k sprave uzivatele
public class User {

    private int reputation;



    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    //Tato metoda nacte reputaci uzivatele
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

    //Tato metoda aktualizuje reputaci uzivatele.
    public boolean updateReputation() {
        ArrayList<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/game/user"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int reputation = Integer.parseInt(parts[1].trim());
                    reputation += 2;
                    updatedLines.add(name + "," + reputation);
                } else {
                    updatedLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/game/user"))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
