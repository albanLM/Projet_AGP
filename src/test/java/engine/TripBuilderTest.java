package engine;

import data.Excursion;
import data.Trip;
import ihm.Criteria;
import ihm.EnumComfort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripBuilderTest {
    @Mock Criteria criteriaMock;
    @Mock ExcursionBuilder excursionBuilderMock;
    @InjectMocks TripBuilder tripBuilder;

    @Test
    void buildTrips() {
        MockitoAnnotations.initMocks(this);
        ArrayList<Excursion> excursions = new ArrayList<Excursion>();
        excursions.add(mock(Excursion.class));
        excursions.add(mock(Excursion.class));
        when(excursionBuilderMock.buildExcursions()).thenReturn(excursions);

        // Tester que buildTrip renvoie bien une des offres

        assertDoesNotThrow(() -> {
            ArrayList<Trip> trips = tripBuilder.buildTrips();
        }, "building trips should not fail");

        ArrayList<Trip> trips = tripBuilder.buildTrips();

        // Vérification
        assertFalse(trips.isEmpty(), "returned list shouldn't be empty");
    }
}