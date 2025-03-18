package game.commands;

import game.ExtraDialogue;
import game.ExtraDialoguesLoad;
import game.User;
import game.World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TryToSolve extends Command{
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
        World w = new World();
        w.loadMap();
        w.loadCurrentRoom();
        ExtraDialoguesLoad ex = new ExtraDialoguesLoad();
        User u = new User();
        ex.load();
        String filepath = "";
        String answer = "";
        int prom = 1;
        String input;
        for(int i = 0;i<ex.getDialogues().size();i++){
            if(ex.getDialogues().get(i).getId()==w.getcurrentRoom().getId()){
                filepath = ex.getDialogues().get(i).getFilePath();
                answer = ex.getDialogues().get(i).getAnswer();
            }
        }
        if(w.getPersons().get(w.getcurrentRoom().getId()).isWantToSolve()){
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line); // Výpis každého řádku
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Zadej odpoved na otazku");
        input = sc.next();
        while(prom == 0){
            if(input.equals(answer)){
                System.out.println("Spravne");
                prom = 1;
                u.updateReputation();

            }else{
                System.out.println("Zkus to znovu");
            }
        }


        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
