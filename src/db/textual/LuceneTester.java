package db.textual;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;

public class LuceneTester {
		
	   private static String indexDir = "indexFiles";
	   private static String dataDir = "inputFiles";
	   
	   public static void main(String[] args) {
		   
		   LuceneSystem system; 
	         system = new LuceneSystem(indexDir, dataDir);
	         try {
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
				e.printStackTrace();
			}
	         
	      
	   }

	 
}