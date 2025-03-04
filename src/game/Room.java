package game;

import java.util.ArrayList;

public class Room {
    private String name;
    private int id;

    private int minReputation;
    private ArrayList<Integer> availableRooms = new ArrayList<>();

    @Override
    public String toString() {
        return "game.Room{" +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinReputation() {
        return minReputation;
    }

    public void setMinReputation(int minReputation) {
        this.minReputation = minReputation;
    }

    public Room(String name, int id) {
        this.name = name;
        this.id = id;
    }


}
