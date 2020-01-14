package db.textual;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import jdk.nashorn.internal.parser.JSONParser;

public class LuceneTester {

	   private static String indexDir = "indexFiles";
	   private static String dataDir = "inputFiles";

	   public static void main(String[] args) {
		   LuceneSystem system;
		   BuildRequest builder; 
		   builder = new BuildRequest(); 
	         system = new LuceneSystem(indexDir, dataDir);
	         try {
	        	system.createIndex();
	        	system.search("activité baignade");
				String[] split = ParseRequest.splitSqlText("Select * from Event Where id=1 WITH salut");
				for(String s : split) {
					System.out.println(s);
				}

				System.out.println(ParseRequest.isWith("Select * from"));
				String request = "{  \n" + 
						"   \"type\":\"hotel\",\n" + 
						"   \"where\":[  \n" + 
						"      {  \n" + 
						"         \"article\":\"article_text\",\n" + 
						"         \"document\":\"document_text\"\n" + 
						"      }\n" + 
						"   ],\n" + 
						"   \"search\":\"hotel\"\n" +
						"}"; 
				
				JSONObject json = new JSONObject(request);
				builder.buildQuery(json, "SELECT X X FROM");
				System.out.println(builder.getQuery());
				System.out.println(builder.isAskingHotel()); 
			} catch (IOException | ParseException | JSONException e) {
				e.printStackTrace();
			}


	   }


}
