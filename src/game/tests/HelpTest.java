package game.tests;

import game.commands.Help;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
//Tato trida testuje metody ze tridy Help
class HelpTest {

    //Tato metoda slouzi k testovani souboru, ktery ma byt vypsan.
    @Test
    void testExecute() throws IOException {
        // Vytvoření testovacího souboru
        File testFile = new File("src/game/help");
        testFile.getParentFile().mkdirs(); // Zajistí, že adresář existuje
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("Testovací obsah souboru");
        }

        Help instance = new Help();
        assertDoesNotThrow(instance::execute, "Metoda execute by neměla vyhazovat výjimky");

        // Úklid - smazání testovacího souboru
        testFile.delete();
    }
}