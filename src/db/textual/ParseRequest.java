package db.textual;

public class ParseRequest {
	
	private String query; 
	public ParseRequest(String query) {
		this.query = query; 
	}
	
	public String[] splitSqlText() {
	        return query.split("(?i)with");
	}
	
	public boolean isWith() {
		return query.contains("with"); 
	}
}