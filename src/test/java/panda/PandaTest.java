package panda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

class PandaTest {
    Panda panda = new Panda(100, 100, 150, 150);

    @Test
    void addressIsCalculatedCorrectly() {
        Point point = panda.address();
        assertEquals(100, point.x);
        assertEquals(100, point.y);
    }

    @Test
    void widthIsCalculatedCorrectly() {
        assertEquals(187, panda.width());
    }

    @Test
    void heightIsCalculatedCorrectly() {
        assertEquals(275, panda.height());
    }
}