package db.textual;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
	   private static String indexDir = "indexFiles";
	   private static String dataDir = "inputFiles";

	   public static void main(String[] args) {
		   LuceneSystem system; 
	         system = new LuceneSystem(indexDir, dataDir);
	         try {
	        	 system.createIndex();
	        	 system.search("Le palais");
				String[] parse = ParseRequest.splitSqlText("Select * from Event Where id=1 WITH salut"); 
				for(String s : parse) {
					System.out.println(s);
				}
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
	         
	      
	   }

	 
}