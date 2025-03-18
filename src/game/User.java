package game;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private String name;
    private int reputation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public boolean loadUser(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/game/user"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                name = data[0];
                reputation = Integer.parseInt(data[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return true;
    }

    public boolean updateReputation() {
        ArrayList<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/game/user"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int reputation = Integer.parseInt(parts[1].trim());
                    reputation += 2; //
                    updatedLines.add(name + ", " + reputation); // Nový řádek
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
