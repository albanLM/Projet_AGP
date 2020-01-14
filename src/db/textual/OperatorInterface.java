package db.textual;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.json.JSONException;

public interface OperatorInterface {

	public void init() throws IOException, ParseException, SQLException, JSONException; 
	
	public boolean hasNext() throws SQLException; 
	
	public Object next(); 
	
	public void reset(); 
}
