package db.textual;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.lucene.queryparser.classic.ParseException;
import org.json.JSONException;

public class APIBde {
	
	private String tableName;
	private String columnName;
	private String inputDir;
	private String indexDir;
	private String idName;
	

	/*Constructeur qui déclare le nom de la table tableName qui contient la clé(le nom du fichier)
	 et de son attribut clé columnName,
	 idName le nom de l'id de la table,
	 ainsi que le nom du répertoire inputDir
	 où seront placés les fichiers texte 
	 et indexDir le dossier ou sont placé les fichiers indexes.
	 */
	public APIBde(String tableName,String columnName,String idName,String inputDir,String indexDir){
		if(APIUtil.indexExist(indexDir)) {
			try {
				if(APIUtil.tableExist(tableName)) {
					if(APIUtil.columnExist(tableName,columnName)) {
						this.tableName = tableName;
						this.columnName = columnName;
						this.idName = idName;
						this.inputDir = inputDir;
						this.indexDir = indexDir;
						
					}else {
						System.out.println("ERREUR : La colonne clé n'existe pas.");
					}
				}else {
					System.out.println("ERREUR : La table n'existe pas.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("ERREUR : L'index n'existe pas, creation de l'index");
			LuceneSystem system = new LuceneSystem(indexDir,inputDir); 
			try {
				system.createIndex();
				try {
					if(APIUtil.tableExist(tableName)) {
						if(APIUtil.columnExist(tableName,columnName)) {
							this.tableName = tableName;
							this.columnName = columnName;
							this.setIdName(idName);
							this.inputDir = inputDir;
							this.indexDir = indexDir;
						}else {
							System.out.println("ERREUR : La colonne clé n'existe pas.");
						}
					}else {
						System.out.println("ERREUR : La table n'existe pas.");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void init(String tableName,String columnName,String inputDir) throws IOException, SQLException {

	}
	
	/* Fonction qui met à jour l'index, par exemple pour ajouter un fichier a index */
	public void updateIndex() {
		LuceneSystem system = new LuceneSystem(indexDir,inputDir);
		APIUtil.deleteFiles("resources/indexFiles");
		try {
			system.createIndex();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Fonction qui execute une requete SQLe 
	 * Si with return un String : score#id#résultat du select
	 * Sinon return un String : id#résultat du select
	 * */
	public ArrayList<String> executeSqle(String query) {
		SqlIterator sqlIt;
        JoinSqlTextual join;
        LuceneSystem system = new LuceneSystem(indexDir,inputDir);
        ArrayList<String> result = new ArrayList<String>();
        
        if (ParseRequest.isWith(query)) {
            join = new JoinSqlTextual(system, query, tableName,columnName,idName);
            try {
            	join.init();
            	//join.next();
            	
                while (join.hasNext()) {
                	
                    result.add(join.next());
                   
                }
                
                Collections.sort(result, Collections.reverseOrder()); 
                
            } catch (IOException | ParseException | SQLException | JSONException e) {
                e.printStackTrace();
            }

           
        } else {
            sqlIt = new SqlIterator(query,tableName,columnName,idName);
            try {
                sqlIt.init();
                while (sqlIt.hasNext()) {
                    result.add(sqlIt.next());
                    //System.out.println("querySQL "+result);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        
        
        //System.out.println("query "+result);
		return result;
		
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getInputDir() {
		return inputDir;
	}

	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	public String getIndexDir() {
		return indexDir;
	}

	public void setIndexDir(String indexDir) {
		this.indexDir = indexDir;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}
}

