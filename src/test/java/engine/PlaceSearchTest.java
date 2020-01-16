package engine;

import data.Place;
import db.FacadeDB;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlaceSearchTest {
    @Mock private static FacadeDB facadeDB;
    @InjectMocks private PlaceSearch placeSearch;

    @Test
    void searchPlaces() {
        MockitoAnnotations.initMocks(this);

        List<Place> placeList = Arrays.asList(mock(Place.class), mock(Place.class), mock(Place.class));
        when(facadeDB.getPlaces(any(JSONObject.class))).thenReturn(new ArrayList<Place>(placeList));

        assertDoesNotThrow(() -> {
            ArrayList<String> keywords = new ArrayList<>(Arrays.asList("keyword1, keyword2"));
            placeSearch.searchPlaces(keywords);
        }, "searching placer should not fail");

        assertEquals(placeSearch.getPlaces(), placeList);
    }
}