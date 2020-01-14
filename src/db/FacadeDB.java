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
import db.textual.BuildRequest;
import db.textual.JoinSqlTextual;
import db.textual.LuceneSystem;
import db.textual.ParseRequest;
import db.textual.SqlIterator;
import db.textual.TextualIterator;
public class FacadeDB {
	
	private BuildRequest build; 
	private LuceneSystem system;
	private JDBCReader jdbc;  
//	private SqlIterator;
//	private TextualIterator; 
//	private MixedIterator;
	
	public FacadeDB(String indexDir, String dataDir) {
		system = new LuceneSystem(indexDir, dataDir);
		jdbc = new JDBCReader(DatabaseConnection.getConnection()); 
		try {
			system.createIndex();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Hotel> getHotels(JSONObject jsonObject) throws JSONException{
		TextualIterator textualIt;
		SqlIterator sqlIt; 
		ArrayList<Hotel> hotels = new ArrayList<Hotel>(); 
		String query = "SELECT id, description FROM place, hotel WHERE " 
			+	"place.id = hotel.id_beach "; 
		build = new BuildRequest(); 
		build.buildQuery(jsonObject, query);
		String sql = build.getQuery(); 
		
		if(ParseRequest.isWith(sql)) {
			String[] split = ParseRequest.splitSqlText(sql); 
			sqlIt = new SqlIterator(split[0]); 
			textualIt = new TextualIterator(system, split[1]);
		}
		else {
			sqlIt = new SqlIterator(sql); 
			try {
				sqlIt.init();
				while(sqlIt.hasNext()) {
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
	
	public ArrayList<Hotel> getBeaches(JSONObject jsonObject) throws JSONException{
		TextualIterator textualIt;
		SqlIterator sqlIt; 
		JoinSqlTextual join; 
		ArrayList<Hotel> beaches = new ArrayList<Hotel>(); 
		String query = "SELECT id, descriptionFile FROM Place, Hotel WHERE "
				+ "Place.id = Hotel.id_beach"; 
		build = new BuildRequest(); 
		build.buildQuery(jsonObject, query);
		String sql = build.getQuery(); 
		if(ParseRequest.isWith(sql)) {
			System.out.println("sasa"); 
			join = new JoinSqlTextual(system, sql); 
			try {
				join.init();
				while(join.hasNext()) {
					System.out.println(join.next()); 
				}
			} catch (IOException | ParseException | SQLException | JSONException e) {
				e.printStackTrace();
			} 
			
			return beaches;
			
		}
		else {
			sqlIt = new SqlIterator(sql); 
			try {
				sqlIt.init();
				while(sqlIt.hasNext()) {
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
		String query = "SELECT id, description FROM place WHERE "; 
		build = new BuildRequest(); 
		build.buildQuery(jsonObject, query);
		String sql = build.getQuery(); 
		TextualIterator textualIt;
		SqlIterator sqlIt; 
		if(ParseRequest.isWith(sql)) {
			String[] split = ParseRequest.splitSqlText(sql); 
		}
		else {
			sqlIt = new SqlIterator(sql); 
			try {
				sqlIt.init();
				while(sqlIt.hasNext()) {
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
