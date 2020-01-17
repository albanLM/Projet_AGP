package engine;

import data.Excursion;
import data.Trip;
import ihm.EnumComfort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TripBuilderTest {
//    @Mock Criteria criteriaMock;
//    @Mock ExcursionBuilder excursionBuilderMock;
//    @InjectMocks TripBuilder tripBuilder;
//
//    @Test
//    void buildTrips() {
//        MockitoAnnotations.initMocks(this);
//        ArrayList<Excursion> excursions = new ArrayList<Excursion>();
//        excursions.add(mock(Excursion.class));
//        excursions.add(mock(Excursion.class));
//        when(excursionBuilderMock.buildExcursions()).thenReturn(excursions);
//
//        // Tester que buildTrip renvoie bien une des offres
//
//        assertDoesNotThrow(() -> {
//            ArrayList<Trip> trips = tripBuilder.buildTrips();
//        }, "building trips should not fail");
//
//        ArrayList<Trip> trips = tripBuilder.buildTrips();
//
//        // Vérification
//        assertFalse(trips.isEmpty(), "returned list shouldn't be empty");
//    }
}