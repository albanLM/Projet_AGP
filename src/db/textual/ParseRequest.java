package db.textual;

public class ParseRequest {
	
	public ParseRequest() {
		
	}
	
	static String[] splitSqlText(String query) {
	        return query.split("(?i)with");
	}
}
