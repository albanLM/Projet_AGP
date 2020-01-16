package engine;

import data.Place;
import db.FacadeDB;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlaceSearch {
    private FacadeDB facadeDB;
    private ArrayList<Place> places;

    public PlaceSearch(FacadeDB facadeDB) {
        this.facadeDB = facadeDB;
    }

    public void searchPlaces(ArrayList<String> keywords) {
        // Construct JSON with keywords
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("keywords", keywords);

        // Request to FacadeDB
        places = facadeDB.getPlaces(jsonObject);
    }

    public FacadeDB getFacadeDB() {
        return facadeDB;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }
}
