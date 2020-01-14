package db.sql;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;


public class BuildRequest {
	
	
	private Connection conn;
	public BuildRequest(Connection co) {
		conn = co ; 
	}
	
	public boolean isAskingHotel(String request) throws JSONException {
		JSONObject jsonObject = new JSONObject(request);
		String type = jsonObject.getString("type"); 
		if(type.equalsIgnoreCase("hotel")) return true; 
		return false; 
	}
	
	public boolean isAskingTransport(String request) throws JSONException {
		JSONObject jsonObject = new JSONObject(request);
		String type = jsonObject.getString("type"); 
		if(type.equalsIgnoreCase("transport")) return true; 
		return false; 
	}
	
	public boolean isAskingPlace(String request) throws JSONException {
		JSONObject jsonObject = new JSONObject(request);
		String type = jsonObject.getString("type"); 
		if(type.equalsIgnoreCase("place")) return true; 
		return false; 
	}
	
	public String build(String request) throws JSONException {
		String sql = ""; 
		JSONObject jsonObject = new JSONObject(request);
		String type = jsonObject.getString("type"); 
		sql = "SELECT * FROM "+type +" WHERE "; 
		JSONArray whereArray = jsonObject.getJSONArray("where"); 
		JSONObject object = whereArray.optJSONObject(0);
	      Iterator<String> iterator = object.keys();
	      while(iterator.hasNext()) {
	        String currentKey = iterator.next();
	        String currentValue = whereArray.getJSONObject(0).getString(currentKey); 
	        
	        sql+= currentKey + " = "+ currentValue;
	        if(iterator.hasNext()) sql+= " AND "; 
	      }
		
        return sql; 
	}

}
