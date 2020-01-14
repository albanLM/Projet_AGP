package db.textual;

import java.util.List;
import java.util.ArrayList;

public class SqlIterator implements OperatorInterface{
	
	private int currentPosition = 0; 
	private List<String> result = new ArrayList<>(); 
	
	
	public SqlIterator() {
		
	}
	
	public void init() {
		
	}
	
	
	public boolean hasNext() {
		return false; 
	}
	
	public int next() {
		return 0;
	}

}
