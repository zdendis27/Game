package game.commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExitTest {
    Exit exit = new Exit();

    @Test
    void testExecute() {
        String result = exit.execute();
        Assertions.assertEquals("", result);
    }

    @Test
    void testExit() {
        boolean result = exit.exit();
        Assertions.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme