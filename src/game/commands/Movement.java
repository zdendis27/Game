package game.commands;

import game.User;
import game.World;

import java.util.Scanner;

public class Movement extends Command {
    World w = new World();
    Scanner sc = new Scanner(System.in);
    User u = new User();


    @Override
    public String execute() {
        w.loadMap();
        w.loadCurrentRoom();
        u.loadUser();

        System.out.println("Nachazis se v mistnosti:");
        if (w.getcurrentRoom() == null) {
            System.out.println("Chyba: currentRoom je null po načtení mapy!");
            return "Chyba: currentRoom nenastavena.";
        }
        System.out.println(w.getcurrentRoom().

                toString());
        System.out.println("Dostupne mistnosti: " + w.getcurrentRoom().

                getAvailableRooms());
        System.out.println("Zadej cislo mistnosti kam chces jit(nebo 99 pro ukonceni)...");

        int loc = 0;
        while (loc != 99) {
            System.out.println(">");
            String input = sc.nextLine().trim();

            try {
                loc = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Musis zadat cislo mistnosti");
                continue;
            }

            if (loc == 99) {
                System.out.println("Ukonceni pohybu. Aktualni mistnost: " + w.getcurrentRoom().getName());
                w.writeCurrentRoom();

                break;
            }



            if (w.getMap().containsKey(loc) && w.getcurrentRoom().getAvailableRooms().contains(loc) && w.getMap().get(loc).getMinReputation() <= u.getReputation()) {
                w.setcurrentRoom(w.getMap().get(loc));



                System.out.println("Presunul jsi se do mistnosti: " + w.getcurrentRoom().toString());
                System.out.println("Dostupne mistnosti: " + w.getcurrentRoom().getAvailableRooms());
                w.writeCurrentRoom();
            } else {
                System.out.println("Neplatna mistnost nebo nemas dostatek reputace, zkus to znovu.");
            }
        }

        return "hotovo";
    }


    @Override
    public boolean exit() {
        return false;
    }


}
