package db;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import data.TransportMethod;
import data.Visit;
import db.textual.*;
import engine.DataSearch;
import org.apache.lucene.queryparser.classic.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import data.Hotel;
import data.Place;
import db.sql.DatabaseConnection;
import db.sql.JDBCReader;

public class FacadeDB {
    private BuildRequest build;
    private LuceneSystem system;
    private JDBCReader jdbc;

    public FacadeDB() {
        system = new LuceneSystem();
        jdbc = new JDBCReader();
        try {
            system.createIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String filename) {
        InputStream is = null;

        try {
            is = new FileInputStream("./src/main/resources/inputFiles/"+filename+".txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            return sb.toString();
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException e) {
            return "";
        }


    }

    public static String createQuery(DataSearch ds){
        String query = "SELECT * FROM ";
        String where = "";
        String objectType = ds.getObjectType();
        ArrayList<String> conditions = ds.getConditions();
        String table = "";

        if (objectType.equals("hotel"))
            table = "place, " + objectType;
        else table = objectType;

        query = query.concat(table);

        if (conditions != null){
            if(objectType.equals("hotel"))
                 where = " WHERE place.id = hotel.id_place AND "+conditions.get(0);
            else where = " WHERE "+ conditions.get(0);

            System.out.println(conditions.size());

            for (int conditionsIndex = 1; conditionsIndex<conditions.size(); conditionsIndex++){
                where = where.concat(" AND " + conditions.get(conditionsIndex));
            }

            query = query.concat(where);
        }
        else if(objectType.equals("hotel")){
            where = " WHERE place.id = hotel.id_place";
        }
        if (ds.getKeywords() != null){
            query = query.concat(" WITH " + ds.getKeywords());
        }


        return query;
    }


    public ArrayList<Visit> getVisits(DataSearch ds) throws SQLException {
        APIBde api = new APIBde("place","description","id","./src/main/resources/inputFiles","./src/main/resources/indexFiles");
        ArrayList<Visit> visits = new ArrayList<>();
        String query = createQuery(ds);
        ArrayList<String> array = api.executeSqle(query);

        for(String str : array){
            String[] result = str.split("#");
            String id = result[0];
            String contents = result[1];
            Visit visit = jdbc.readVisit(Integer.parseInt(id));
            visits.add(visit);
        }
        return visits;
    }

    public ArrayList<Place> getPlaces(DataSearch ds) throws SQLException {
        APIBde api = new APIBde("place","description","id","./src/main/resources/inputFiles","./src/main/resources/indexFiles");
        ArrayList<Place> places = new ArrayList<>();
        String query = createQuery(ds);
        ArrayList<String> array = api.executeSqle(query);

        for(String str : array){
            String[] result = str.split("#");
            String id = result[0];
            String contents = result[1];
            Place place = jdbc.readPlace(Integer.parseInt(id));
            places.add(place);
        }
        return places;
    }

    public TransportMethod getTransportMethods(DataSearch ds) throws SQLException {
        APIBde api = new APIBde("place","description","id","./src/main/resources/inputFiles","./src/main/resources/indexFiles");
        ArrayList<TransportMethod> transportMethods = new ArrayList<>();
        String query = createQuery(ds);
        ArrayList<String> array = api.executeSqle(query);

            String[] result = array.get(0).split("#");
            String id = result[0];
            TransportMethod transportMethod = jdbc.readTransportMethod(Integer.parseInt(id));
        return transportMethod;
    }

    public ArrayList<Hotel> getHotels(DataSearch ds) throws SQLException {
        APIBde api = new APIBde("place","description","id","./src/main/resources/inputFiles","./src/main/resources/indexFiles");
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        String query = createQuery(ds);
        ArrayList<String> array = api.executeSqle(query);

        for(String str : array){
            String[] result = str.split("#");
            String id = result[0];
            String contents = result[1];
            Hotel hotel = jdbc.readHotel(Integer.parseInt(id));

            hotel.setDescriptionFile(readFile(contents));
            hotels.add(hotel);
        }


        return hotels;
    }

    public ArrayList<Hotel> getBeaches(JSONObject jsonObject) throws JSONException {
        SqlIterator sqlIt;
        JoinSqlTextual join;
        ArrayList<Hotel> beaches = new ArrayList<Hotel>();
        String query = "SELECT id, descriptionFile FROM Place, Hotel WHERE "
                + "Place.id = Hotel.id_beach";
        build = new BuildRequest();
        build.buildQuery(jsonObject, query);
        String sql = build.getQuery();
        if (ParseRequest.isWith(sql)) {
            // FIXME : Correct constructor
            join = new JoinSqlTextual(system, sql, "", "", "");
            try {
                join.init();
                while (join.hasNext()) {
                    String result[] = join.next().split("#");
                    String id = result[0];
                    String contents = result[1];
                    Hotel beach = jdbc.readHotel(Integer.parseInt(id));
                    beach.setDescriptionFile(contents);
                    beaches.add(beach);
                }
            } catch (IOException | ParseException | SQLException | JSONException e) {
                e.printStackTrace();
            }

            return beaches;

        } else {
            // FIXME : Correct constructor
            sqlIt = new SqlIterator(sql, "", "", "");
            try {
                sqlIt.init();
                while (sqlIt.hasNext()) {
                    String[] result = sqlIt.next().split("#");
                    Hotel hotel = jdbc.readHotel(Integer.parseInt(result[0]));
                    beaches.add(hotel);
                }
            } catch (IOException | ParseException | SQLException e) {
                e.printStackTrace();
            }
        }
        return beaches;
    }

    public ArrayList<Place> getPlaces(JSONObject jsonObject) throws JSONException {
        ArrayList<Place> places = new ArrayList<Place>();
        JoinSqlTextual join;
        String query = "SELECT id, description FROM place WHERE ";
        build = new BuildRequest();
        build.buildQuery(jsonObject, query);
        String sql = build.getQuery();
        SqlIterator sqlIt;
        if (ParseRequest.isWith(sql)) {
            // FIXME : Correct constructor
            join = new JoinSqlTextual(system, sql, "", "", "");
            try {
                join.init();
                while (join.hasNext()) {
                    String result[] = join.next().split("#");
                    String id = result[0];
                    String contents = result[1];
                    Hotel place = jdbc.readHotel(Integer.parseInt(id));
                    place.setDescriptionFile(contents);
                    places.add(place);
                }
            } catch (IOException | ParseException | SQLException | JSONException e) {
                e.printStackTrace();
            }

            return places;
        } else {
            // FIXME : Correct constructor
            sqlIt = new SqlIterator(sql, "", "", "");
            try {
                sqlIt.init();
                while (sqlIt.hasNext()) {
                    String[] result = sqlIt.next().split("#");
                    Place place = jdbc.readPlace(Integer.parseInt(result[0]));
                    places.add(place);
                }
            } catch (IOException | ParseException | SQLException e) {
                e.printStackTrace();
            }
        }
        return places;
    }
}
