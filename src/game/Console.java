package game;

import game.commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> commands;

    public void initialization(){
        commands = new HashMap<>();
        commands.put("jdi", new Movement());
        commands.put("inv", new OpenInventory());
        commands.put("vem", new PickItem());
        commands.put("dej", new GiveItem());
        commands.put("resit", new TryToSolve());
        commands.put("mluv", new StartConversation());
        commands.put("bojuj", new Fight());
    }

    private void doCommand(){
        System.out.println(">");
        String comm = sc.next();
        if (commands.containsKey(comm)){
            System.out.println(commands.get(comm).execute());
            exit = commands.get(comm).exit();
        }else {
            System.out.println("Zadal jste spatny vyraz");
        }

    }

    public void start(){
        initialization();
        do {
            doCommand();
        }while(!exit);
    }
}
