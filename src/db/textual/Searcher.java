package db.textual;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


public class Searcher {
	
   IndexSearcher indexSearcher;
   QueryParser queryParser;
   Query query;
   
   
   public Searcher(String indexPath) throws IOException {
	   Directory dir = FSDirectory.open(Paths.get(indexPath));

       IndexReader reader = DirectoryReader.open(dir);

       indexSearcher = new IndexSearcher(reader);
   }

   TopDocs search(String textToFind) throws IOException, ParseException {
	   System.out.print("salut0 "+textToFind);
	   TopScoreDocCollector collector = TopScoreDocCollector.create(2, 1);

   	QueryParser qp = new QueryParser("contents", new StandardAnalyzer());

   	Query query = qp.parse(textToFind);

   	indexSearcher.search(query, collector);

       TopDocs hits = indexSearcher.search(query, 100);
       return hits;
   }
   
   public Document getDocument(ScoreDoc scoreDoc) throws CorruptIndexException, IOException {
	   System.out.print("salut0 "+scoreDoc.toString());
		      return indexSearcher.doc(scoreDoc.doc);	
   }
   


}