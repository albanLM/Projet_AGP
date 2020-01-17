package db.textual;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneSystem {
	
	
	private String indexDir;
	private String dataDir;
	private Indexer indexer;
	private Searcher searcher;
	
	public LuceneSystem(String indexDir, String dataDir) {
		
		this.dataDir = dataDir; 
		this.indexDir = indexDir; 
	}
	
	 public void createIndex() throws IOException {
	      indexer = new Indexer(indexDir);
	      indexer.createIndex(dataDir);
	      indexer.close();	
	   }
	   
	   public TopDocs search(String searchQuery) throws IOException, ParseException   {
		      searcher = new Searcher(indexDir);
		      TopDocs hits = searcher.search(searchQuery);
		     

//		      // Iterate a topdocs element and get information about every document
		      
//		      for(ScoreDoc scoreDoc : hits.scoreDocs) {
//		         Document doc = searcher.getDocument(scoreDoc);
//		        System.out.println("File: "+ doc.get("path") + ", Score : " + scoreDoc.score + " type : "+doc.get("type"));
//		      } 
			return hits;
		      
		   }

	public Indexer getIndexer() {
		return indexer;
	}

	public void setIndexer(Indexer indexer) {
		this.indexer = indexer;
	}

	public Searcher getSearcher() {
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	public String getIndexDir() {
		return indexDir;
	}

	public void setIndexDir(String indexDir) {
		this.indexDir = indexDir;
	}

	public String getDataDir() {
		return dataDir;
	}

	public void setDataDir(String dataDir) {
		this.dataDir = dataDir;
	}
	   
	   
}
