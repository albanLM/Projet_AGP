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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TripBuilderTest {
    private Criteria criteria;
    private ArrayList<Excursion> excursionsMock;
    @Mock private ExcursionBuilder excursionBuilder;
    @InjectMocks private TripBuilder tripBuilder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        excursionsMock.add(mock(Excursion.class));

//        when(excursionBuilder.buildExcursions()).thenReturn();

        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("string1");
        int minPrice = 10;
        int maxPrice = 50;
        int numberOfDay = 5;

        criteria = new Criteria(numberOfDay, minPrice, maxPrice, keywords, EnumComfort.Relaxing, 0);
    }

    @Test
    void buildTrips() {
        int keywordCountStart = criteria.getKeywords().size();
        int keywordCountEnd;
        ArrayList<Trip> trips;

        trips = tripBuilder.buildTrips(criteria);

        keywordCountEnd = criteria.getKeywords().size();
        assertTrue(keywordCountStart < keywordCountEnd, "building trips should add keywords");
        assertNotEquals(criteria.getExcursionCount(), 0, "excursion count should be set");
    }
}