package db.textual;
import java.util.ArrayList;
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
	
	public void buildQuery(JSONObject jsonObject, String sql) throws JSONException {
		query = sql; 
		System.out.println();
		if(jsonObject.has("where")) {
			query+=" WHERE "; 
			ArrayList<String> whereArray = (ArrayList<String>) jsonObject.get("where"); 
			
		    Iterator<String> iterator = whereArray.listIterator();
		      while(iterator.hasNext()) {
		        
		        query += " "+iterator+" "; 
		        if(iterator.hasNext()) query+= " AND "; 
		      }
		}
		if(jsonObject.has("search")) {
			String search; 
			search = jsonObject.getString("search"); 
			query+= " WITH "+ search; 
		}
		System.out.println(query); 
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
