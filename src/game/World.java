package game;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Tato trida slouzi k sprave herniho prostredi.
 */
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

    /**
     * Tato metoda nacte mapu hry.
     * @author Tato metoda byla prepracovana za pomoci Chat GPT
     */

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


    /**
     * Tato metoda nacte postavy ze hry.
     */

    public boolean loadPersons() {
        persons.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("src/game/persons"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.matches("\\d+")) {
                    continue;
                }

                String[] parts = line.split(";");
                while (parts.length < 7) {
                    parts = Arrays.copyOf(parts, parts.length + 1);
                    parts[parts.length - 1] = "null";
                }

                int roomId = Integer.parseInt(parts[0]);
                Person p = new Person(roomId, parts[1], parts[2], Boolean.parseBoolean(parts[3]), Boolean.parseBoolean(parts[4]), parts[5], parts[6]);

                while (persons.size() <= roomId) {
                    persons.add(null);
                }

                persons.set(roomId, p);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor persons nebyl nalezen.", e);
        } catch (IOException e) {
            throw new RuntimeException("Chyba při čtení souboru persons.", e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Chyba při převodu čísla v persons.", e);
        }
        return true;
    }


    /**
     * Tato metoda nacte aktualni lokaci.
     */

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


    /**
     * Tato metoda prepise aktualni lokaci.
     */

    public boolean writeCurrentRoom() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/game/currentLoc"))) {
            bw.write(String.valueOf(currentRoom.getId()));
        } catch (IOException e) {
            System.out.println("Chyba při zápisu do souboru: " + e.getMessage());
        }
        return true;
    }

    /**
     * Tato metoda slozi k odstraneni itemu po sebrani
     * @author Tato metoda byla vytvorena za pomoci ChatGPT
     */

    public void removeItem() {
        try {
            Path path = Paths.get("src/game/mapa");
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path));

            List<String> noveRadky = new ArrayList<>();
            for (String line : lines) {
                if (line.contains("varecka")) {
                    line = line.replace("varecka", "Zadny");
                }
                if(line.contains("hodinky")){
                    line = line.replace("hodinky", "Zadny");
                }
                if(line.contains("lektvar")){
                    line = line.replace("lektvar", "Zadny");
                }

                noveRadky.add(line);
            }

            Files.write(path, noveRadky, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
