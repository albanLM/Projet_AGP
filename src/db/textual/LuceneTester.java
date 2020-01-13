package db.textual;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
	   private String indexDir = "indexFiles";
	   private String dataDir = "inputFiles";
	   private Indexer indexer;
	   private Searcher searcher;
	   public static void main(String[] args) {
	      LuceneTester tester;
	         tester = new LuceneTester();
	         try {
				tester.createIndex();
				tester.search("Le palais");
				String[] parse = ParseRequest.splitSqlText("Select * from Event Where id=1 WITH salut"); 
				for(String s : parse) {
					System.out.println(s);
				}
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
	         
	      
	   }

	   private void createIndex() throws IOException {
	      indexer = new Indexer(indexDir);
	      indexer.createIndex(dataDir);
	      indexer.close();
	      		
	   }
	   
	   private void search(String searchQuery) throws IOException, ParseException   {
		      searcher = new Searcher(indexDir);
		      long startTime = System.currentTimeMillis();
		      TopDocs hits = searcher.search(searchQuery);
		      long endTime = System.currentTimeMillis();

		      System.out.println(hits.totalHits +
		         " documents found. Time :" + (endTime - startTime) +" ms");
		      for(ScoreDoc scoreDoc : hits.scoreDocs) {
		         Document doc = searcher.getDocument(scoreDoc);
		         System.out.println("File: "+ doc.get("path") + ", Score : " + scoreDoc.score + " type : "+doc.get("type"));
		      }
		      
		   }
}