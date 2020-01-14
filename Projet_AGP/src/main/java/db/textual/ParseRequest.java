package db.textual;

public class ParseRequest {
	
	public static String[] splitSqlText(String query) {
	        return query.split("(?i)with");
	}
	
	public static boolean isWith(String query) {
		return query.contains("with"); 
	}
}


