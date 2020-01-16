package db.textual;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildRequestTest {
    BuildRequest buildRequest;

    @BeforeEach
    void setUp() {
        buildRequest = new BuildRequest();
    }

    @Test
    void buildQuery() {
        JSONObject jsonRequest = new JSONObject();
        JSONArray jsonWhereArray = new JSONArray();
        JSONObject jsonWhere = new JSONObject();

        jsonWhere.put("pricePerDay", ">10");

        jsonWhereArray.put(jsonWhere);

        jsonRequest.put("type", "hotel");
        jsonRequest.put("where", jsonWhereArray);
        jsonRequest.put("search", "Gortyne");

        String sql = "";
        buildRequest.buildQuery(jsonRequest, sql);

        assertEquals("SELECT id, description FROM Place, Hotel WHERE Place.id = Hotel.id_beach  AND  pricePerDay > 10  WITH Gortyne", sql);
    }
}