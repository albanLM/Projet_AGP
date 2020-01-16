package db.textual;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.TopDocs;

import static db.textual.RessourcePath.dataDirectoryPath;

public class LuceneSystem {
    private Indexer indexer;
    private Searcher searcher;

    public LuceneSystem() {}

    public void createIndex() throws IOException {
        indexer = new Indexer();
        indexer.createIndex(dataDirectoryPath);
        indexer.close();
    }

    public TopDocs search(String searchQuery) throws IOException, ParseException {
        searcher = new Searcher();
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
}
