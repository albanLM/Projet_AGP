package db.textual;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
<<<<<<< HEAD
import org.apache.lucene.search.ScoreDoc;
=======
import org.json.JSONException;

import db.sql.BuildRequest;
>>>>>>> dd607a3378ae91fe86bc714c6fec8bdf038258e8

public class LuceneTester {

	   private static String indexDir = "indexFiles";
	   private static String dataDir = "inputFiles";
<<<<<<< HEAD
	   
=======

>>>>>>> dd607a3378ae91fe86bc714c6fec8bdf038258e8
	   public static void main(String[] args) {
		   LuceneSystem system;
		   BuildRequest builder; 
		   builder = new BuildRequest(); 
	         system = new LuceneSystem(indexDir, dataDir);
	         try {
<<<<<<< HEAD
//	        	system.createIndex();
//	        	system.search("baignade"); 
	        	TextualIterator it = new TextualIterator(system,"baignade");
	        	it.init();
	        	
	        	while(it.hasNext()) {
	        		ScoreDoc d = it.next();
		        	System.out.println(d.toString());
		        	Document doc = system.getSearcher().getDocument(d);
		        	d = it.next();
		        	System.out.println("Fileeeeeeee: "+ doc.get("path") + ", Score :  type : "+ d.score);
	        	}
	        	
	        	
	        			System.out.println(ParseRequest.isWith("Select * from"));
			} catch (IOException | ParseException e) {
=======
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
						"   ]\n" + 
						"}"; 
				System.out.println(builder.isAskingHotel(request)); 
			} catch (IOException | ParseException | JSONException e) {
>>>>>>> dd607a3378ae91fe86bc714c6fec8bdf038258e8
				e.printStackTrace();
			}


	   }


}
