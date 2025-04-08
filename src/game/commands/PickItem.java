package game.commands;

import game.Inventory;
import game.Room;
import game.World;

import java.util.Scanner;

/**
 * Tato trida resi prikaz k sebrani predmetu.
 */

public class PickItem extends Command {
    Scanner sc = new Scanner(System.in);

    /**
     *     Metoda, diky ktere muze uzivatel sebrat predmet a pridat si ho do inventare.
     */
    @Override
    public String execute() {
        World w = new World();
        w.loadMap();
        w.loadCurrentRoom();
        Inventory inv = new Inventory();
        String item = w.getcurrentRoom().getItem();


        System.out.println("V mistnosti se nachazi tento predmet: " + w.getcurrentRoom().getItem());
        System.out.println("Chces tento predmet presunout do inventare? (ano/ne)");

        String input = sc.nextLine();
        if (input.equals("ano") && inv.getItem()==null&&item !=null&&!item.equals("Zadny")) {
            inv.addItem(item);
            w.getcurrentRoom().setItem(null);
            w.removeItem();

            return "Pridal jsi do inventare " + item;
        } else {
            return "Pridani se nepovedlo";
        }
    }


    @Override
    public boolean exit() {
        return false;
    }
}
