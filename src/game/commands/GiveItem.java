package game.commands;

import game.Inventory;
import game.Person;
import game.User;
import game.World;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GiveItem extends Command{
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
        World w = new World();
        Inventory inv = new Inventory();
        User u = new User();
        inv.loadInventory();
        w.loadMap();
        w.loadPersons();

        // Ověření, zda osoba existuje a má požadovaný předmět
        Person currentPerson = w.getPersons().get(w.getcurrentRoom().getId());
        if (currentPerson == null || currentPerson.getWantedItem() == null || currentPerson.getWantedItem().trim().isEmpty()) {
            System.out.println("Žádná osoba v této místnosti nepožaduje předmět.");
            return "hotovo";
        }

        System.out.println("Osoba v této místnosti žádá tento předmět: " + currentPerson.getWantedItem());
        System.out.println("Ve vašem inventáři se nachází tento předmět: " + inv.getItem());
        System.out.println("Chcete tento váš předmět odevzdat? (ano/ne)");

        String input = sc.nextLine();
        if (input.equals("ano") && inv.getItem().trim().equals(currentPerson.getWantedItem().trim())) {
            ArrayList<String> updatedLines = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("src/game/persons"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("/");
                    if (parts.length >= 6 && parts[2].trim().equals(currentPerson.getWantedItem().trim())) {
                        parts[2] = "null";
                    }
                    updatedLines.add(String.join("/", parts));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/game/persons"))) {
                for (String updatedLine : updatedLines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            u.updateReputation();
        } else {
            System.out.println("Přidání se nezdařilo");
        }

        return "hotovo";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
