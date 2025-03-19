package game;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

public class World {

private HashMap<Integer, Room> map = new HashMap<>();
private Room currentRoom;
private ArrayList<Person> persons = new ArrayList<>();


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

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/game/mapa"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("/");

                ArrayList<String> partsList = new ArrayList<>(Arrays.asList(parts));
                while (partsList.size() < 5) {
                    partsList.add("");
                }
                parts = partsList.toArray(new String[0]);

                String[] rooms = parts[2].trim().isEmpty() ? new String[0] : parts[2].trim().split("\\s+");
                String item = parts[4].trim().isEmpty() ? null : parts[4];

                Room r = new Room(parts[1], Integer.parseInt(parts[0]), Integer.parseInt(parts[3]), item);

                for (String room : rooms) {
                    if (!room.isEmpty()) {
                        r.getAvailableRooms().add(Integer.parseInt(room));
                    }
                }

                map.put(Integer.parseInt(parts[0]), r);
            }
            setcurrentRoom(map.get(1));

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor mapa nebyl nalezen!", e);
        } catch (IOException e) {
            throw new RuntimeException("Chyba při čtení souboru!", e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Chyba formátu čísla: " + e.getMessage(), e);
        }
        return true;
    }




    public boolean loadPersons(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/game/persons"))){
            String line;
            while((line = br.readLine())!=null){
                String[] parts = line.split("/");

                ArrayList<String> partsList = new ArrayList<>(Arrays.asList(parts));
                while (partsList.size() < 7) {
                    partsList.add("null");
                }
                parts = partsList.toArray(new String[0]);
                Person p = new Person(parseInt(parts[0]),parts[1],parts[2],Boolean.parseBoolean(parts[3]), Boolean.parseBoolean(parts[4]), parts[5],parts[6]);
                persons.add(p);


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
}

    public boolean loadCurrentRoom() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/game/currentLoc"))) {
            String line = br.readLine();

            if (line == null || line.trim().isEmpty()) {
                return false;
            }

            int roomId;
            try {
                roomId = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                return false;
            }

            if (!map.containsKey(roomId)) {
                return false;
            }

            setcurrentRoom(map.get(roomId));
            return true;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public boolean writeCurrentRoom() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/game/currentLoc"))) {
            bw.write(String.valueOf(currentRoom.getId()));
        } catch (IOException e) {
            System.out.println("Chyba při zápisu do souboru: " + e.getMessage());
        }
        return true;
    }






}
