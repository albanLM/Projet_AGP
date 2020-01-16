package integration;

import data.Trip;
import engine.TripBuilder;
import ihm.Criteria;
import ihm.EnumComfort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EngineIntegrationTest {
    private TripBuilder tripBuilder;
    private Criteria criteria;

    @BeforeEach
    public void setUp () {
        criteria = new Criteria(5, 200, 1000, new ArrayList<String>(Arrays.asList("baignade", "port", "touristique")), EnumComfort.Sportive, null, null);
        tripBuilder = new TripBuilder(criteria);
    }

    @Test
    void testEngine() {
        assertDoesNotThrow(()-> {
            tripBuilder.buildTrips();
        }, "building trip list should not fail");
        ArrayList<Trip> trips = tripBuilder.getProposedTrips();

        assertFalse(trips.isEmpty(), "Trip list should not be empty");

        for (Trip trip :
                trips) {
            assertNotNull(trip.getHotel(), "Hotels should exist for each trip");
            assertFalse(trip.getExcursions().isEmpty(), "Excursion list should not be empty");
            assertFalse(trip.getPrice() > criteria.getMaxPrice(), "Trip price should be lower than maximum price");
        }
    }
}
