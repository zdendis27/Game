package game.commands;
/**
 * Trida, ktera resi opusteni programu.
 */
public class Exit extends Command{


    /**
     *     Metoda pro opustemi programu.
     */
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
