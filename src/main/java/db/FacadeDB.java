package db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import engine.DataSearch;
import org.apache.lucene.queryparser.classic.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import data.Hotel;
import data.Place;
import db.sql.DatabaseConnection;
import db.sql.JDBCReader;
import db.textual.BuildRequest;
import db.textual.JoinSqlTextual;
import db.textual.LuceneSystem;
import db.textual.ParseRequest;
import db.textual.SqlIterator;

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
        if (ds.getKeywords() != null){
            query = query.concat(" WITH " + ds.getKeywords());
        }


        return query;
    }

    public ArrayList<Hotel> getHotels(JSONObject jsonObject) throws JSONException {
        SqlIterator sqlIt;
        JoinSqlTextual join;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        String query = "SELECT id, description FROM place, hotel WHERE "
                + "place.id = hotel.id_beach ";
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
                    Hotel hotel = jdbc.readHotel(Integer.parseInt(id));
                    hotel.setDescriptionFile(contents);
                    hotels.add(hotel);
                }
            } catch (IOException | ParseException | SQLException | JSONException e) {
                e.printStackTrace();
            }

            return hotels;
        } else {
            // FIXME : Correct constructor
            sqlIt = new SqlIterator(sql, "", "", "");
            try {
                sqlIt.init();
                while (sqlIt.hasNext()) {
                    String[] result = sqlIt.next().split("#");
                    Hotel hotel = jdbc.readHotel(Integer.parseInt(result[0]));
                    hotels.add(hotel);
                }
            } catch (IOException | ParseException | SQLException e) {
                e.printStackTrace();
            }
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
