package db.textual;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JoinSqlTextual implements IteratorInterface{

	private LuceneSystem lucene;
	private String queryJson;
	private List<String> results = new ArrayList<>();
	private int currentPosition = 0;
	private String tableName;
	private String columnName;
	private String idName;
	
	public JoinSqlTextual(LuceneSystem lucene,String queryJson,String tableName,String columnName,String idName) {
		this.queryJson = queryJson;
		this.lucene = lucene;
		this.tableName = tableName;
		this.columnName = columnName;
		this.idName = idName;
	}

	@Override
	public void init() throws IOException, ParseException, SQLException, JSONException {
		TextualIterator textualIterator;
		SqlIterator sqlIterator;
    	
		String[] queryAll = ParseRequest.splitSqlText(queryJson);

		String querySql = queryAll[0];
		String queryTextual = queryAll[1];
		ScoreDoc textualIt = null;
		String sqlIt  = null;
		
			textualIterator = new TextualIterator(lucene, queryTextual);
			sqlIterator = new SqlIterator(querySql,tableName,columnName,idName);
			
			sqlIterator.init();
			textualIterator.init();

			while(sqlIterator.hasNext()) {
				
				textualIt = textualIterator.next();
				sqlIt = sqlIterator.next();
				
        		String[] rsR = sqlIt.split("#");
        		System.out.println(sqlIt);
        		while(textualIterator.hasNext()) {
        			
		        	Document doc = lucene.getSearcher().getDocument(textualIt);
		        	System.out.println(rsR[0]+"=="+rsR[1]+"#"+textualIt.score+"#"+doc.get("path"));
		        	
		        	if(doc.get("path").equals(rsR[1])){
		        		String addRes = "score:"+textualIt.score+"#id:"+rsR[0]+"#"+doc.get("contents");

						System.out.println(rsR[0]+"=="+rsR[1]+"#"+textualIt.score+"#"+doc.get("contents"));
		        		for(int i = 2; i<rsR.length;i++) {
		        			addRes = addRes +"#"+ rsR[i];
		        		}
		        		
		        		results.add(addRes);
		        		System.out.println("resultat : "+ addRes);
		        	}
		        	textualIt = textualIterator.next();
		        	
        		}
        		textualIterator.reset();
        	}
	}

	@Override
	public String toString() {
		return "JoinSqlTextual [results=" + results + "]";
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

        currentPosition ++;
        return doc; 
	}
	
	public String position() {
		String doc = results.get(currentPosition);
        return doc; 
	}
	
	@Override
	public void reset() {
		currentPosition = 0;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
