package db.textual;

import java.util.List;
import java.util.ArrayList;

public class SqlIterator implements OperatorInterface{
	
	private int currentPosition = 0; 
	private List<String> result = new ArrayList<>(); 
	
	
	public SqlIterator() {
		
	}
	
	public void init() {
		if (result.size() == 0) {
          
        }
	}
	
	
	public boolean hasNext() {
		init();
        return currentPosition < result.size();
    }
	
	public int next() {
		if(!hasNext()) {
			return 1; 
		}
		return 0; 
	}

	@Override
	public void reset() {
		currentPosition = 0; 
	}
	
	

}
