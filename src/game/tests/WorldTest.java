package game.tests;

import game.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void testLoadMap() {
        World world = new World();
        assertTrue(world.loadMap(), "Metoda loadMap by měla vracet true");
        assertNotNull(world.getcurrentRoom(), "Aktuální místnost by neměla být null");
    }

    @Test
    void testLoadPersons() {
        World world = new World();
        assertTrue(world.loadPersons(), "Metoda loadPersons by měla vracet true");
        assertNotNull(world.getPersons(), "Seznam osob by neměl být null");
    }

    @Test
    void testLoadCurrentRoom() {
        World world = new World();
        world.loadMap();
        assertTrue(world.loadCurrentRoom(), "Metoda loadCurrentRoom by měla vracet true");
        assertNotNull(world.getcurrentRoom(), "Aktuální místnost by neměla být null");
    }

    @Test
    void testWriteCurrentRoom() {
        World world = new World();
        world.loadMap();
        world.setcurrentRoom(world.getMap().get(1));
        assertTrue(world.writeCurrentRoom(), "Metoda writeCurrentRoom by měla vracet true");
    }

}