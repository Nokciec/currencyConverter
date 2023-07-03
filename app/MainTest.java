package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    @Test
    void argsForDebug() throws Exception {
        String [] debugArgs = Main.argsForDebug();
        assertEquals("17.50" , debugArgs[0]);
        assertEquals("CAD" , debugArgs[1]);
        assertEquals("JPY" , debugArgs[2]);

    }
}