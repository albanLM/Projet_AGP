package db.textual;


import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
   String indexDir = "indexFiles";
   String dataDir = "inputFiles";
   Indexer indexer;
   Searcher searcher;
   
   public static void main(String[] args) {
      LuceneTester tester;
         tester = new LuceneTester();
         try {
			tester.createIndex();
			tester.search("Akrotiri");
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
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
	         System.out.println("File: "+ doc.get("path") + ", Score : " + scoreDoc.score);
	      }
	      
	   }
}