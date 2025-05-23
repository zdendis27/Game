package game;

import java.util.ArrayList;

/**
 * Tato trida slouzi k inicializaci mistnosti.
 */

public class Room {
    private String name;
    private int id;

    private int minReputation;
    private ArrayList<Integer> availableRooms = new ArrayList<>();
    private String item;

    @Override
    public String toString() {
        return "Nachazite se v " + name +
                " (ID: " + id + ", Min. reputace: " + minReputation + ")" +
                "\nDostupne mistnosti: " + availableRooms +
                "\nPredmet: " + (item == null ? "Zadny" : item);
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

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }


    public Room(String name, int id, int minReputation,String item) {
        this.name = name;
        this.id = id;
        this.minReputation = minReputation;
        this.item = item;
    }



}
