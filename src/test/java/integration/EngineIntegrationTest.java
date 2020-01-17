package integration;

import data.Trip;
import engine.Criteria;
import engine.EnumTripType;
import engine.TripBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EngineIntegrationTest {
    private TripBuilder tripBuilder;
    private Criteria criteria;

    @BeforeEach
    public void setUp () {
        criteria = new Criteria(5, 1000, new ArrayList<String>(Arrays.asList("baignade", "port", "touristique")), EnumTripType.B);
        tripBuilder = new TripBuilder();
    }

    @Test
    void testEngine() {
        assertDoesNotThrow(()-> {
            tripBuilder.buildTrip(criteria);
        }, "Building trip list should not fail");

        Trip trip = null;
        try {
            trip = tripBuilder.buildTrip(criteria);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertNotNull(trip, "Build trip should not be null");

        assertNotNull(trip.getHotel(), "Hotels should exist for each trip");
        assertFalse(trip.getExcursions().isEmpty(), "Excursion list should not be empty");
        assertFalse(trip.getPrice() > criteria.getMaxPrice(), "Trip price should be lower than maximum price");
    }
}
