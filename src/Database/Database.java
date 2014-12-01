
package Database;

import Logica.*;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;



public class Database {
    
    private static final String db = "BINFG07";
    private static final String user = "BINFG07";
    private static final String pasw = "2eI7mqfv";
    
    private Connection dbConnection = null;
    
    public Connection getConnection(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String protocol = "jdbc";
            String subProtocol = "mysql";
            String subName = "//mysqlha2.ugent.be/" + db +
                    "?user=" + user +
                    "&password=" + pasw;

            String URL = protocol +":"+ subProtocol +":"+subName;

            dbConnection = DriverManager.getConnection(URL);
            
            return dbConnection;
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            try{
                dbConnection.close();
            } 
            catch (Exception e){}
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            try{
                dbConnection.close();
            } 
            catch (Exception e){}
            return null;
        }
    }
    
    public void closeConnection(){
        try {
            dbConnection.close();
        } 
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            try{
                dbConnection.close();
            } 
            catch (Exception e){}
        }
    }
    
    public ResultSet getData(String opdracht){
        
        ResultSet srs = null;
        
        try{
            dbConnection = getConnection();
            
            Statement stmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = opdracht;
            srs = stmt.executeQuery(sql);

            return srs;
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return srs;
        }
    }
    
   
    
    public Klant getKlant(String gebruikersnaam){
        try{
            String sql = "SELECT * FROM klant WHERE login = " + gebruikersnaam + ";";
            ResultSet srs = getData(sql);
            if(srs.next()){
                
                String naam = srs.getString("naam");
                String voornaam = srs.getString("voornaam");
                String email = srs.getString("email");
                String straatnaam = srs.getString("straatnaam");
                int huisnummer = srs.getInt("huisnummer");
                String gemeente = srs.getString("gemeente");
                 int postcode = srs.getInt("postcode");
                int gsm = srs.getInt("gsm");
                String password = srs.getString("password");
                Klant a = new Klant(naam, voornaam, gebruikersnaam, email, postcode, gemeente, huisnummer, gsm, password, straatnaam);
                this.closeConnection();
                return a;
                
                
            }
            else return null;
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
        
        
    }
    
    
    //*

    
  }  
    
    
   
    
    
    
    
    
    
    
    