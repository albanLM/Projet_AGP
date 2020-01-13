package db.textual;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;

public class LuceneTester {
		
	   private static String indexDir = "indexFiles";
	   private static String dataDir = "inputFiles";
	   static ParseRequest parse; 
	   
	   public static void main(String[] args) {
		   
		   LuceneSystem system; 
	         system = new LuceneSystem(indexDir, dataDir);
	         try {
	        	 
//	        	alreadyExecuted = true;
	        	 
      	 
	        	 system.search("activité");
				parse = new ParseRequest("Select * from Event Where id=1 WITH salut");
				String[] split = parse.splitSqlText(); 
				for(String s : split) {
					System.out.println(s);
				}
				parse = new ParseRequest("Select * from"); 
				System.out.println(parse.isWith());
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
	         
	      
	   }

	 
}