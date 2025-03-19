package game;

import java.io.*;
import java.util.ArrayList;

public class Inventory {

    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean addItem(String s){
        try (FileWriter writer = new FileWriter("src/game/inventory")) {
            writer.write(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean loadInventory(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/game/inventory"))){
            item = br.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public void removeItemFromFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("null"); // Přepíše obsah souboru na "null"
        } catch (IOException e) {
            System.out.println("Chyba při přepisování souboru inventáře.");
        }
    }

}
