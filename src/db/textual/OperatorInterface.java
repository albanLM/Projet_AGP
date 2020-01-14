package db.textual;

public interface OperatorInterface {

	public void init(); 
	
	public boolean hasNext(); 
	
	public int next(); 
	
	public void reset(); 
}
