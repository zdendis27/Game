package game;

import
        java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class World {

private HashMap<Integer, Room> map = new HashMap<>();
private Room currentRoom;

    public Room getcurrentRoom() {
        return currentRoom;
    }

    public void setcurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public HashMap<Integer, Room> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, Room> map) {
        this.map = map;
    }

    public boolean loadMap(){
    try(BufferedReader br = new BufferedReader(new FileReader("src/mapa"))) {
        String line;
        while((line = br.readLine())!=null){
            String[] parts = line.split("/");
            String[] rooms = parts[2].trim().split(" ");

            Room r = new Room(parts[1],Integer.parseInt(parts[0]));
            for(int i = 0;i< rooms.length;i++){
                r.getAvailableRooms().add(Integer.parseInt(rooms[i]));

            }
            map.put(Integer.parseInt(parts[0]),r);

        }
        setcurrentRoom(map.get(1));

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return true;
}
}
