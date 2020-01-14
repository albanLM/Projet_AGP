package db.sql;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class BuildRequest {
	
	private String type; 
	private String sql; 
	HashMap<String, String> where = new HashMap<String, String>(); 
	
	public BuildRequest() {
		
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
	
	public void search(String request) throws JSONException {
		JSONObject jsonObject = new JSONObject(request);
		type = jsonObject.getString("type"); 
		JSONArray whereArray = jsonObject.getJSONArray("where"); 
		JSONObject object = whereArray.optJSONObject(0);
	    Iterator<String> iterator = object.keys();
	      while(iterator.hasNext()) {
	        String currentKey = iterator.next();
	        String currentValue = whereArray.getJSONObject(0).getString(currentKey); 
	        where.put(currentKey, currentValue); 
	      }
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HashMap<String, String> getWhere() {
		return where;
	}

	public void setWhere(HashMap<String, String> where) {
		this.where = where;
	}
}
