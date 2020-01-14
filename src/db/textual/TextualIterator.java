package db.textual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class TextualIterator implements OperatorInterface {
	
	private LuceneSystem lucene; 
	private int currentPosition = 0;
	private List<ScoreDoc> results = new ArrayList<>();
	private String query; 
	
	public TextualIterator(LuceneSystem lucene, String query) {
		this.lucene = lucene; 
		this.query = query; 
	}
	
	@Override
	public void init() throws IOException, ParseException {
		 if (results.size() == 0) {
	           	TopDocs hits = lucene.search(query); 
	            for (ScoreDoc doc: hits.scoreDocs) {
	                this.results.add(doc);
	            }
	        }
	}

	@Override
	public boolean hasNext() {
		return currentPosition < results.size();
	}

	@Override
	public ScoreDoc next() {
		if (!hasNext()) {
            return null;
        }
        ScoreDoc doc = results.get(currentPosition);
        currentPosition++;
        return doc;
        
	}

	@Override
	public void reset() {
		currentPosition = 0;

	}

}
