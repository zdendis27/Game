package game.commands;

import game.World;

import java.util.Scanner;

public class Movement extends Command {
    World w = new World();
    Scanner sc = new Scanner(System.in);



    @Override
    public String execute() {

        w.loadMap();
        System.out.println("Nachazis se v mistnosti:");
        System.out.println(w.getcurrentRoom().toString());
        System.out.println("Dostupne mistnosti: " + w.getcurrentRoom().getAvailableRooms());
        System.out.println("Zadej cislo mistnosti kam chces jit(nebo 99 pro ukonceni)...");

        int loc = 0;
        while(loc!=99){
            System.out.println(">");
            String input = sc.nextLine().trim();



        try {
            loc = Integer.parseInt(input);
        }catch (Exception e){
            System.out.println("Musis zadat cislo mistnosti");
            continue;
        }

        if(loc==99){
            break;
        }


            if (loc == w.getcurrentRoom().getId()) {
                System.out.println("V teto mistnosti se prave nachazis");
                continue;
            }



            if (w.getMap().containsKey(loc) && w.getcurrentRoom().getAvailableRooms().contains(loc)) {
                w.setcurrentRoom(w.getMap().get(loc));
                System.out.println("Presunul jsi se do mistnosti: " + w.getcurrentRoom().toString());
                System.out.println("Dostupne mistnosti: " + w.getcurrentRoom().getAvailableRooms());
            } else {
                System.out.println("Neplatna mistnost, zkus to znovu.");
            }
        }


        return "hotovo";
    }





    @Override
    public boolean exit() {
        return false;
    }


}
