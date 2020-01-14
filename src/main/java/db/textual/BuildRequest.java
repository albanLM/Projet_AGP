package db.textual;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class BuildRequest {
	
	private String type; 
	private String query; 
	
	public BuildRequest() {
		
	}
	
	public boolean isAskingHotel() {
		return type.equalsIgnoreCase("Hotel"); 
	}
	
	public boolean isAskingTransport() {
		return type.equalsIgnoreCase("Transport"); 
	}
	
	public boolean isAskingPlace() {
		return type.equalsIgnoreCase("place"); 
	}
	
	public void buildQuery(JSONObject jsonObject, String query) throws JSONException {
		
		if(jsonObject.has("where")) {
			query+=" WHERE "; 
			JSONArray whereArray = jsonObject.getJSONArray("where"); 
			JSONObject object = whereArray.optJSONObject(0);
		    Iterator<String> iterator = object.keys();
		      while(iterator.hasNext()) {
		        String currentKey = iterator.next();
		        String currentValue = whereArray.getJSONObject(0).getString(currentKey); 
		        query += currentKey+" = "+currentValue; 
		        if(iterator.hasNext()) query+= " AND "; 
		      }
		}
		if(jsonObject.has("search")) {
			String search; 
			search = jsonObject.getString("search"); 
			query+= " WITH "+ search; 
		}
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
