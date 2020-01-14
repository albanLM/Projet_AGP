package db;

import java.awt.List;

import org.json.JSONException;
import org.json.JSONObject;

import data.Hotel;
import db.textual.BuildRequest;
import db.textual.ParseRequest;
public class FacadeDB {
	
	private BuildRequest build; 
	
	public FacadeDB() {
		
	}
	
	public List getHotels(JSONObject jsonObject) throws JSONException{
		String query = "SELECT id, description FROM place, hotel WHERE " 
			+	"place.id = hotel.id_beach "; 
		build = new BuildRequest(); 
		build.buildQuery(jsonObject, query);
		String sql = build.getQuery(); 
		
		if(ParseRequest.isWith(sql)) {
			
		}
		else {
			
		}
		
		return null;
	}
	
	public List getBeaches(JSONObject jsonObject) throws JSONException{
		String query = "SELECT id, description FROM place, hotel WHERE "
				+ "place.id = hotel.id_beach "; 
		build = new BuildRequest(); 
		build.buildQuery(jsonObject, query);
		String sql = build.getQuery(); 
		if(ParseRequest.isWith(sql)) {
			
		}
		else {
			
		}
		return null;
	}
	
	public List getPlaces(JSONObject jsonObject) throws JSONException {
		String query = "SELECT id, description FROM place WHERE "; 
		build = new BuildRequest(); 
		build.buildQuery(jsonObject, query);
		String sql = build.getQuery(); 
		if(ParseRequest.isWith(sql)) {
			
		}
		else {
			
		}
		return null; 
	}
}
