package game;

/**
 * Tato trida slouzi k spusteni cele hry.
 */
public class Run {
    GameStart g = new GameStart();
    Console c = new Console();
    /**
     * Tato metoda spusti hru.
     */

    public boolean run() {
        g.prologue();
        g.setStartingFiles();
        c.start();

        return true;
    }

}
