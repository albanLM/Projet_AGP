package db.textual;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;

public class LuceneTester {

	   private static String indexDir = "indexFiles";
	   private static String dataDir = "inputFiles";


	   public static void main(String[] args) {

		   LuceneSystem system;
	         system = new LuceneSystem(indexDir, dataDir);
	         try {
	        	system.createIndex();
	        	system.search("activité baignade");
				String[] split = ParseRequest.splitSqlText("Select * from Event Where id=1 WITH salut");
				for(String s : split) {
					System.out.println(s);
				}

				System.out.println(ParseRequest.isWith("Select * from"));
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}


	   }


}
