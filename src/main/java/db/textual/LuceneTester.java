package db.textual;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.queryparser.classic.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import data.Hotel;
import db.FacadeDB;
import jdk.nashorn.internal.parser.JSONParser;

public class LuceneTester {

	   private static String indexDir = "indexFiles";
	   private static String dataDir = "inputFiles";

	   public static void main(String[] args) {
		   FacadeDB facade = new FacadeDB(indexDir, dataDir); 

				
		   String request = "{  \n" + 
						"   \"type\":\"hotel\",\n" + 
						"   \"where\":[  \n" + 
						"      {  \n" + 
						"         \"pricePerDay\":\">10\" "+ 
						"      }\n" + 
						"   ],\n" + 
						"   \"search\":\"Gortyne\"\n" +
						"}"; 
				
				try {
					JSONObject json = new JSONObject(request);
					ArrayList<Hotel> hotels = facade.getBeaches(json); 
					for (int i = 0; i < hotels.size(); i++) {
					      System.out.println(hotels.get(i).getDescriptionFile());
					    }
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			

	   }


}
