package game.commands;

import game.Inventory;
//Tato trida resi prikaz pro zobrazeni inventare.
public class OpenInventory extends Command{

    //Metoda pro zobrazeni inventare.
    @Override
    public String execute() {
        Inventory inv = new Inventory();
        inv.loadInventory();

        return inv.getItem();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
