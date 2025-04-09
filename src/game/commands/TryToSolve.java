package game.commands;

import game.ExtraDialogue;
import game.ExtraDialoguesLoad;
import game.User;
import game.World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * V teto tride je resen prikaz na vyreseni hadanky.
 */

public class TryToSolve extends Command{
    Scanner sc = new Scanner(System.in);
    private int password = 0;

    /**
     * Tato metoda spusti dialog, ktery je potreba pro uhodnuti hadanky
     *  a necha uzivatele hadat odpoved.
     */

    @Override
    public String execute() {
        World w = new World();
        w.loadMap();
        w.loadCurrentRoom();
        w.loadPersons();
        ExtraDialoguesLoad ex = new ExtraDialoguesLoad();
        User u = new User();
        ex.load();

        String filepath = "";
        String answer = "";
        boolean solved = false;
        Scanner sc = new Scanner(System.in);

        if(w.getcurrentRoom().getId()!=1) {

            for (int i = 0; i < ex.getDialogues().size(); i++) {
                if (ex.getDialogues().get(i).getId() == w.getcurrentRoom().getId()) {
                    filepath = ex.getDialogues().get(i).getFilePath();
                    answer = ex.getDialogues().get(i).getAnswer();
                }
            }


            if (!w.getPersons().get(w.getcurrentRoom().getId()).isWantToSolve()) {
                System.out.println("V teto mistnosti neni nikdo, kdo by chtel resit hadanku.");
                return "hotovo";
            }

            if (w.getPersons().get(w.getcurrentRoom().getId()).isWantToSolve()) {
                try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Chyba pri nacitani hadanky.");
                    e.printStackTrace();
                    return "hotovo";
                }

                System.out.println("Zadej odpoved na otazku:");
                while (!solved) {
                    String input = sc.next();
                    if (input.equalsIgnoreCase(answer)) {
                        System.out.println("Spravne");
                        if(password == 0){
                            u.updateReputation();
                            password = 1;
                        }else {
                            System.out.println("Uz jsi mi odpovedel");
                        }

                        solved = true;
                    } else {
                        System.out.println("Spatna odpoved, zkus to znovu:");
                    }
                }
            } else {
                System.out.println("Nikdo v teto mistnosti nechce resit hadanku.");
            }
        }else{
            return "Nikdo v teto mistnosti nechce resit hadanku.";
        }

        return "hotovo";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
