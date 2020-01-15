package engine;

import ihm.Criteria;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripBuilderTest {
    private TripBuilder tripBuilder;
    private Criteria criteria;

    @BeforeAll
    static void beforeAll() {
        TripBuilder tripBuilder = new TripBuilder();
    }

    @BeforeEach
    void setUp() {
        criteria = new Criteria();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buildTrips() {
    }

    @Test
    void getLowerPriceTrip() {
    }

    @Test
    void getMostExpensiveTrip() {
    }

    @Test
    void getMostPertinentTrip() {
    }

    @Test
    void addKeywords() {
    }
}