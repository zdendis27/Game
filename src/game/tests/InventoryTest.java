package game.tests;

import game.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Tato trida testuje metody ze tridy Inventory.
class InventoryTest {

    //Tato metoda testuje [ridani do inevntare.
    @Test
    void testAddItem() {
        Inventory inventory = new Inventory();
        assertFalse(inventory.addItem("Meč"), "Metoda addItem by měla vracet false");
    }


    //Tato metoda testuje pridani do inventare.
    @Test
    void testLoadInventory() {
        Inventory inventory = new Inventory();
        inventory.addItem("Luk");
        assertTrue(inventory.loadInventory(), "Metoda loadInventory by měla vracet true");
        assertEquals("Luk", inventory.getItem(), "Položka v inventáři by měla být 'Luk'");
    }

    //Tato metoda testuje odstraneni z inventare.
    @Test
    void testRemoveItemFromFile() {
        Inventory inventory = new Inventory();
        inventory.addItem("Štít");
        inventory.removeItemFromFile("src/game/inventory");
        inventory.loadInventory();
        assertEquals("null", inventory.getItem(), "Položka by měla být přepsána na 'null'");
    }

}