package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {
    Coordinates coordinates = new Coordinates(0, 0);

    @BeforeEach
    void setUp() {
        coordinates = new Coordinates(0, 0);
    }

    @Test
    void setX() {
        coordinates.setX(5);
        assertEquals(coordinates.getX(), 5);
    }

    @Test
    void setY() {
        coordinates.setY(5);
        assertEquals(coordinates.getY(), 5);
    }
}