package db.textual;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import db.sql.DatabaseConnection;

public class APIUtil {
	
	public APIUtil() {
		
	}
	
	public static boolean indexExist(String path) {
		try {
			Directory index = FSDirectory.open (Paths.get(path));
			return DirectoryReader.indexExists(index);			
		}
		catch (Exception e) {
			throw new RuntimeException ("could not load event index", e);
		}
	}
	
	public static boolean tableExist(String tName) throws SQLException {
	    boolean tExists = false;
	    DatabaseConnection db = null;
	    Connection conn = db.getConnection();
	    try (ResultSet rs = conn.getMetaData().getTables(null, null, tName, null)) {
	    	if (rs.next()) { 
	            tExists = true;  
	        }
	    }
	    return tExists;
	}
	
	public static boolean columnExist(String tName,String cName) throws SQLException {
	    boolean tExists = false;
	    DatabaseConnection db = null;
	    Connection conn = db.getConnection();
	    try (ResultSet rs = conn.getMetaData().getColumns(null, null, tName, cName)) {
	        if (rs.next()) { 
	            tExists = true;  
	        }
	    }
	    return tExists;
	}
	
	public static void deleteFiles(String file){
	  File path = new File(file);
	  if(path.exists()){
	    File[] files = path.listFiles();
	    for( int i = 0 ; i < files.length ; i++ ){
	      if(files[ i ].isDirectory()){
	    	  deleteFiles( path+"\\"+files[ i ] );
	      }
	      files[ i ].delete();
	    }
	  }
	}
}
