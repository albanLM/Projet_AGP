package db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.lucene.queryparser.classic.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import data.Hotel;
import data.Place;
import db.sql.DatabaseConnection;
import db.sql.JDBCReader;
import db.textual.RequestBuilder;
import db.textual.JoinSqlTextual;
import db.textual.LuceneSystem;
import db.textual.ParseRequest;
import db.textual.SqlIterator;

public class FacadeDB {
<<<<<<< HEAD
    private BuildRequest build;
=======
    private RequestBuilder build;
>>>>>>> d713672209318de08a4743fdf92d5b7376c0b921
    private LuceneSystem system;
    private JDBCReader jdbc;

    public FacadeDB() {}

    public void init() {
        try {
            system.createIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Hotel> getHotels(JSONObject jsonObject) throws JSONException {
        SqlIterator sqlIt;
        JoinSqlTextual join;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        String query = "SELECT id, description FROM place, hotel WHERE "
                + "place.id = hotel.id_beach ";

        build = new RequestBuilder();
        build.buildQuery(jsonObject, query);
        String sql = build.getQuery();

        if (ParseRequest.isWith(sql)) {
            join = new JoinSqlTextual(system, sql);
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
            sqlIt = new SqlIterator(sql);
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
        build = new RequestBuilder();
        build.buildQuery(jsonObject, query);
        String sql = build.getQuery();
        if (ParseRequest.isWith(sql)) {
            join = new JoinSqlTextual(system, sql);
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
            sqlIt = new SqlIterator(sql);
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
        build = new RequestBuilder();
        build.buildQuery(jsonObject, query);
        String sql = build.getQuery();
        SqlIterator sqlIt;
        if (ParseRequest.isWith(sql)) {
            join = new JoinSqlTextual(system, sql);
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
            sqlIt = new SqlIterator(sql);
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

<<<<<<< HEAD
    // TODO : Ajouter une fonction pour récupérer les véhicules
=======
    public RequestBuilder getBuild() {
        return build;
    }

    public void setBuild(RequestBuilder build) {
        this.build = build;
    }

    public LuceneSystem getSystem() {
        return system;
    }

    public void setSystem(LuceneSystem system) {
        this.system = system;
    }

    public JDBCReader getJdbc() {
        return jdbc;
    }

    public void setJdbc(JDBCReader jdbc) {
        this.jdbc = jdbc;
    }
>>>>>>> d713672209318de08a4743fdf92d5b7376c0b921
}
