package integration;

import data.Hotel;
import db.FacadeDB;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DataBaseIntegrationTest {
    private FacadeDB facadeDB;

    @BeforeEach
    public void setUp () {
        facadeDB = new FacadeDB();
    }

    @Test
    public void testDatabaseAPI() {
        JSONObject jsonRequest = new JSONObject();
        JSONArray jsonWhereArray = new JSONArray();
        JSONObject jsonWhere = new JSONObject();

        jsonWhere.put("pricePerDay", ">10");
        jsonWhere.put("fs3gskg", "<10");

        jsonWhereArray.put(jsonWhere);

        jsonRequest.put("type", "hotel");
        jsonRequest.put("where", jsonWhereArray);
        jsonRequest.put("search", "Gortyne");

        assertDoesNotThrow(()->{
            ArrayList<Hotel> hotels = facadeDB.getHotels(jsonRequest);
        });

//        System.out.println(hotels);
    }
}
