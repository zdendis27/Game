public class Main {
    public static void main(String[] args) {
        World w = new World();
        w.loadMap();

        System.out.println(w.getMap().toString());

    }
}