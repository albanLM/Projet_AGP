package engine;

import data.Hotel;
import data.Place;
import data.TransportMethod;
import data.Visit;
import db.FacadeDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataSearch {


    private String objectType;
    private ArrayList<String> conditions;
    private String keywords;
    private FacadeDB fdb = new FacadeDB("./src/main/resources/indexFiles","./src/main/resources/inputFiles");

    public DataSearch(String objectType, ArrayList<String> conditions, String keywords) {
        this.objectType = objectType;
        this.conditions = conditions;
        this.keywords = keywords;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<String> conditions) {
        this.conditions = conditions;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public ArrayList<Hotel> searchHotel() throws SQLException {
        return fdb.getHotels(this);
    }

    public ArrayList<Place> searchPlace(){

        try {
            return fdb.getPlaces(this);
        } catch (SQLException e) {
            ArrayList<Place> places = new ArrayList<>();
            return places;
        }
    }

    public TransportMethod searchTransport(){

        try {
            return fdb.getTransportMethods(this);
        } catch (SQLException e) {
            return new TransportMethod("bus", 100, 5);
        }
    }

    public ArrayList<Visit> searchVisit(){
        ArrayList<Visit> list = new ArrayList<>();

        try {
            return fdb.getVisits(this);
        } catch (SQLException e) {
            return new ArrayList<Visit>();
        }
    }

}
