import java.util.ArrayList;

public class Room {
    private String name;
    private int id;
    private ArrayList<Integer> availableRooms = new ArrayList<>();

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", availableRooms=" + availableRooms +
                '}';
    }

    public ArrayList<Integer> getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(ArrayList<Integer> availableRooms) {
        this.availableRooms = availableRooms;
    }

    public Room(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
