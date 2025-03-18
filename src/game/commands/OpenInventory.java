package game.commands;

import game.Inventory;

public class OpenInventory extends Command{
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
