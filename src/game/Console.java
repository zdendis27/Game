package game;

import game.commands.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Tato trida slouzi k fungovani prikazu.
 */

public class Console {
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> commands;

    /**
     * Tato metoda inicializuje jednotlive prikazy.
     */

    public void initialization(){
        commands = new HashMap<>();
        commands.put("jdi", new Movement());
        commands.put("inv", new OpenInventory());
        commands.put("vem", new PickItem());
        commands.put("dej", new GiveItem());
        commands.put("resit", new TryToSolve());
        commands.put("mluv", new StartConversation());
        commands.put("bojuj", new Fight());
        commands.put("exit", new Exit());
        commands.put("help", new Help());
    }


    /**
     * Tato metoda se stara o spravne spustenia ukonceni commandu.
     */
    private void doCommand() {
        World w = new World();
        User u = new User();
        w.loadMap();
        w.loadCurrentRoom();
        u.loadUser();

        Endgame e = new Endgame();

        if (w.getcurrentRoom().getId() != 8) {
            System.out.println("Tva reputace je: " + u.getReputation());
            System.out.println(w.getcurrentRoom().toString());
            System.out.print(">");

            if (!sc.hasNextLine()) {
                // Pokud není žádný vstup, místo ukončení programu vypiš info a pokračuj dál
                System.out.println("Zadej prosím příkaz.");
                return;
            }

            String comm = sc.nextLine().trim().toLowerCase();

            if (comm.isEmpty()) {
                System.out.println("Zadej prosím příkaz.");
                return;
            }

            if (commands.containsKey(comm)) {
                System.out.println(commands.get(comm).execute());
                exit = commands.get(comm).exit();
            } else {
                System.out.println("Zadal jste špatný výraz");
            }
        }

        if (w.getcurrentRoom().getId() == 8) {
            e.endgame();
            exit = true;
        }
    }

    /**
     * Tato metoda spousti prikazovou cast hry.
     */

    public void start(){
        initialization();
        do {
            doCommand();
        }while(!exit);
    }
}
