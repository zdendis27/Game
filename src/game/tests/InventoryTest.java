package game.tests;

import game.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    @Test
    void testAddItem() {
        Inventory inventory = new Inventory();
        assertFalse(inventory.addItem("Meč"), "Metoda addItem by měla vracet false");
    }

    @Test
    void testLoadInventory() {
        Inventory inventory = new Inventory();
        inventory.addItem("Luk");
        assertTrue(inventory.loadInventory(), "Metoda loadInventory by měla vracet true");
        assertEquals("Luk", inventory.getItem(), "Položka v inventáři by měla být 'Luk'");
    }

    @Test
    void testRemoveItemFromFile() {
        Inventory inventory = new Inventory();
        inventory.addItem("Štít");
        inventory.removeItemFromFile("src/game/inventory");
        inventory.loadInventory();
        assertEquals("null", inventory.getItem(), "Položka by měla být přepsána na 'null'");
    }

}