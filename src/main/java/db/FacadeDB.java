package db;

import java.awt.List;
import java.io.IOException;

import db.textual.BuildRequest;
import db.textual.LuceneSystem;
import db.textual.ParseRequest;
import org.json.JSONException;
import org.json.JSONObject;

import data.Hotel;

public class FacadeDB {
	
	private BuildRequest build;
	private LuceneSystem system;
	
	public FacadeDB(String indexDir, String dataDir) {
		system = new LuceneSystem(indexDir, dataDir);
		try {
			system.createIndex();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List getHotels(JSONObject jsonObject) throws JSONException{
		String query = "SELECT id, description FROM place, hotel WHERE " 
			+	"place.id = hotel.id_beach "; 
		build = new BuildRequest(); 
		build.buildQuery(jsonObject, query);
		String sql = build.getQuery(); 
		
		if(ParseRequest.isWith(sql)) {
			String[] split = ParseRequest.splitSqlText(sql); 
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
			String[] split = ParseRequest.splitSqlText(sql); 
			
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
			String[] split = ParseRequest.splitSqlText(sql); 
		}
		else {
			
		}
		return null; 
	}
}
