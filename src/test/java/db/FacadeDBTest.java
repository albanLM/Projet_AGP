package db;

import data.Hotel;
import data.Place;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FacadeDBTest {
    private static String indexDir;
    private static String dataDir;
    private static String request;
    private static FacadeDB facade;

    @BeforeAll
    static void beforeAll() {
        indexDir = "indexFiles";
        dataDir = "inputFiles";

        facade = new FacadeDB(indexDir, dataDir);
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHotels() {
        request = "{  \n" +
                "   \"type\":\"hotel\",\n" +
                "   \"where\":[  \n" +
                "      {  \n" +
                "         \"pricePerDay\":\">10\" " +
                "      }\n" +
                "   ],\n" +
                "   \"search\":\"Gortyne\"\n" +
                "}";

        JSONObject json = new JSONObject(request);
        assertDoesNotThrow(() -> {
            facade.getHotels(json);
        });
    }

    @Test
    void getBeaches() {
        request = "{  \n" +
                "   \"type\":\"hotel\",\n" +
                "}";

        JSONObject json = new JSONObject(request);
        ArrayList<Hotel> hotelBeaches;
        assertDoesNotThrow(() -> {
            facade.getBeaches(json);
        });
//        assertNotEquals(places, null);
    }

    @Test
    void getPlaces() {
        request = "{  \n" +
                "   \"type\":\"place\",\n" +
                "}";

        JSONObject json = new JSONObject(request);
        assertDoesNotThrow(() -> {
            facade.getPlaces(json);
        });
    }
}