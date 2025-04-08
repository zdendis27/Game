package game.tests;

import game.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tato trida testuje metody ze tridy World.
 */

class WorldTest {

    /**
     * Tato metoda testuje nacteni mapy.
     */

    @Test
    void testLoadMap() {
        World world = new World();
        assertTrue(world.loadMap(), "Metoda loadMap by měla vracet true");
        assertNotNull(world.getcurrentRoom(), "Aktuální místnost by neměla být null");
    }

    /**
     * Tato metoda testuje nacteni osob.
     */

    @Test
    void testLoadPersons() {
        World world = new World();
        assertTrue(world.loadPersons(), "Metoda loadPersons by měla vracet true");
        assertNotNull(world.getPersons(), "Seznam osob by neměl být null");
    }

    /**
     *     Tato metoda testuje nacteni aktualni mistnosti.
     */
    @Test
    void testLoadCurrentRoom() {
        World world = new World();
        world.loadMap();
        assertTrue(world.loadCurrentRoom(), "Metoda loadCurrentRoom by měla vracet true");
        assertNotNull(world.getcurrentRoom(), "Aktuální místnost by neměla být null");
    }

    /**
     * Tato metoda testuje prepsani aktualni mistnosti.
     */

    @Test
    void testWriteCurrentRoom() {
        World world = new World();
        world.loadMap();
        world.setcurrentRoom(world.getMap().get(1));
        assertTrue(world.writeCurrentRoom(), "Metoda writeCurrentRoom by měla vracet true");
    }

}