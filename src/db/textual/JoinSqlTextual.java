package db.textual;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.json.JSONException;

public class JoinSqlTextual implements OperatorInterface{

	private LuceneSystem lucene;
	private String queryJson;
	private List<String> results = new ArrayList<>();
	private int currentPosition = 0;
	
	public JoinSqlTextual(LuceneSystem lucene,String queryJson) {
		this.queryJson = queryJson;
		this.lucene = lucene;
	}

	@Override
	public void init() throws IOException, ParseException, SQLException, JSONException {
		TextualIterator textualIterator;
		SqlIterator sqlIterator;
	
		System.out.println("JoinSqlTextual : "+queryJson);
    	
		String[] queryAll = ParseRequest.splitSqlText(queryJson);

		String querySql = queryAll[0];
		String queryTextual = queryAll[1];
			
			textualIterator = new TextualIterator(lucene, queryTextual);
			sqlIterator = new SqlIterator(querySql);
			
			sqlIterator.init();
			textualIterator.init();
			
			while(sqlIterator.hasNext()) {
        		String rs = (String) sqlIterator.next();
        		String[] rsR = rs.split("#");
        		while(textualIterator.hasNext()) {
        			ScoreDoc d = textualIterator.next();
		        	Document doc = lucene.getSearcher().getDocument(d); 
		        	if(doc.get("path").equalsIgnoreCase(rsR[1])){
		        		System.out.println("ssaaaasas");
		        		String addRes = rsR[0]+"#"+doc.get("contents")+"#"+d.score; 
		        		results.add(addRes);
		        	}
		        	d = textualIterator.next();
        		}
        		textualIterator.reset();
        	}
			
	}

	@Override
	public boolean hasNext() {
		return currentPosition < results.size();
	}

	@Override
	public String next() {
		if (!hasNext()) {
            return null;
        }
        String doc = results.get(currentPosition);
        System.out.println("ssss"+doc); 
        currentPosition ++;
        return doc; 
	}

	@Override
	public void reset() {
		currentPosition = 0;
	}
}
