package game.commands;

import game.User;
import game.World;

import java.util.Random;
import java.util.Scanner;

/**
 * Trida obsahujici mechaniku souboje.
 */
public class Fight extends Command{
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);

    /**
     *     Metoda ktera resi mechaniku souboje a muze diky ni uzivatel v urcite mistnosti spustit souboj.
     */
    @Override
    public String execute() {

        int carlHP = 35;
        int adamHP = 35;
        boolean carlTurn = true;
        boolean defended = false;
        World w = new World();
        w.loadMap();
        w.loadCurrentRoom();
        User u = new User();

        if (w.getcurrentRoom().getId() == 4) {
            System.out.println("Generál Adam tě vyzývá na souboj!");

            while (carlHP > 0 && adamHP > 0) while (carlHP > 0 && adamHP > 0) {
                if (carlTurn) {
                    System.out.println("\nTvůj tah! (1 - Útok, 2 - Obrana)");
                    int choice = 0;

                    // smyčka pro validaci vstupu
                    while (true) {
                        if (sc.hasNextInt()) {
                            choice = sc.nextInt();
                            if (choice == 1 || choice == 2) {
                                break;
                            } else {
                                System.out.println("Zadej pouze 1 (útok) nebo 2 (obrana):");
                            }
                        } else {
                            System.out.println("Zadej číslo 1 nebo 2:");
                            sc.next(); // spotřebuje neplatný vstup
                        }
                    }

                    if (choice == 1) {
                        int attack = rd.nextInt(6) + 5;
                        adamHP -= attack;
                        System.out.println("Carl zaútočil a způsobil " + attack + " poškození! Adam má " + adamHP + " HP.");
                        defended = false;
                    } else {
                        System.out.println("Carl se brání a sníží příští poškození.");
                        defended = true;
                    }

                } else {
                    int attack = rd.nextInt(5) + 4;
                    if (defended) {
                        attack /= 2;
                    }
                    carlHP -= attack;
                    System.out.println("Adam zaútočil a způsobil " + attack + " poškození! Carl má " + carlHP + " HP.");
                }

                carlTurn = !carlTurn;
            }


            if (carlHP > 0) {
                System.out.println("\nVyhrál jsi souboj!");
                u.updateReputation();
            } else {
                System.out.println("\nProhrál jsi...");
            }



        }else{
            System.out.println("V teto mistnosti nelze bojovat");
        }
        return "";
    }



    @Override
    public boolean exit() {
        return false;
    }
}
