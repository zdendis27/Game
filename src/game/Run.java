package game;

public class Run {
    GameStart g = new GameStart();
    Console c = new Console();
    public boolean run() {
        g.prologue();
        g.setStartingFiles();
        c.start();

        return true;
    }

}
