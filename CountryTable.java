
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ni.jug.controller.CountryTable
 *  Crea una tabla con los paises del mundo en español
 *  @author   :Gustavo Castro <gacsnic75@gmail.com>
 *  @license  :MIT 
 *  @version  :0.1
 *  @link     :https://github.com/gacsnic/tabla-paises
 */

public class CountryTable {
    private Connection cnn=null;
    private static final String CREATESQL="CREATE TABLE IF NOT EXISTS Country (" +
        "   Id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
        "   iso_code	INTEGER ," +
        "   isoa1_code	TEXT," +
        "   isoa2_code	TEXT," +
        "   Country 	TEXT);";

    public CountryTable(Connection cnn){
        this.cnn=cnn;
        createTable();
        addCountry();
        }
    /**
     * "ni.jug.controller.CountryTable"
     * Crea la tabla donde se guardaran los paises
     */
    private void createTable(){
	PreparedStatement pst=null;
	try {
            pst=cnn.prepareStatement(CREATESQL);
            pst.execute();
	}catch( SQLException e){
	     e.printStackTrace(System.out);
	}finally {
            try {
           	if(pst!=null)
                    pst.close();
	    }catch( SQLException e){
	        e.printStackTrace(System.out);
	    }
        }		   
    }
    
    /**
     * "ni.jug.controller.CountryTable"
     *Agrega los paises a la tabla
     */
    private void addCountry(){
        String fichero = "addcountry.sql";
        String contry;
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            PreparedStatement pst=null;
           try {
                cnn.setAutoCommit(false);
                while((contry = br.readLine()) != null){
                    pst=cnn.prepareStatement(contry);
                    pst.execute();
                }
                cnn.commit();
           }catch( SQLException e){
                try {
                    cnn.rollback();
                }catch(SQLException ex){
                   ex.printStackTrace(System.err);
                }
               e.printStackTrace(System.err);
            }finally {
                 try {
                     cnn.setAutoCommit(true);
                    if(pst!=null)
                        pst.close();
                    }catch( SQLException e){
                         e.printStackTrace(System.err);
                    }
                }		   
            fr.close();
        }catch(IOException e) {
           e.printStackTrace(System.err);
        }    
    }
    
}
