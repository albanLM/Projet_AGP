package db;

import data.Hotel;
import db.sql.JDBCReader;
import db.textual.BuildRequest;
import db.textual.LuceneSystem;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

class FacadeDBTest {
    @Mock private BuildRequest build;
    @Mock private LuceneSystem system;
    @Mock private JDBCReader jdbc;
    @InjectMocks private static FacadeDB facade;

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        when(build.getQuery()).thenReturn("SELECT id FROM place");
    }

    @Test
    void getHotels() {
        JSONObject jsonRequest = new JSONObject();
        /*JSONArray jsonWhereArray = new JSONArray();
        JSONObject jsonWhere = new JSONObject();

        jsonWhere.put("pricePerDay", ">10");
        jsonWhereArray.put(jsonWhere);

        jsonRequest.put("type", "hotel");
        jsonRequest.put("where", jsonWhereArray);
        jsonRequest.put("search", "Gortyne");*/

        assertDoesNotThrow(() -> {
            facade.getHotels(jsonRequest);
        }, "getting hotels should not fail");
    }

    @Test
    void getBeaches() {
/*        request = "{  \n" +
                "   \"type\":\"hotel\"\n" +
                "}"*/;

        JSONObject json = new JSONObject();
        ArrayList<Hotel> hotelBeaches;
        assertDoesNotThrow(() -> {
            facade.getBeaches(json);
        });
//        assertNotEquals(places, null);
    }

    @Test
    void getPlaces() {
/*        request = "{  \n" +
                "   \"type\":\"place\"\n" +
                "}"*/;

        JSONObject json = new JSONObject();
        assertDoesNotThrow(() -> {
            facade.getPlaces(json);
        });
    }
}