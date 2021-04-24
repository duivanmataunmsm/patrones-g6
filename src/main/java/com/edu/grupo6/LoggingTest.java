package com.edu.grupo6;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LoggingTest {

    @org.junit.jupiter.api.Test
    void testLog() {
        Logging logging = new Logging();
        Logger log = logging.getLogger();

        log.info("Esto es un mensaje de test");

        assertEquals(log.getName(), "ChessLog");
    }
}