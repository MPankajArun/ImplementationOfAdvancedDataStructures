/**
 * 
 */
package DataMapping;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dany
 *
 */
public class DataConnection {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		try {  
			Statement stt;
			
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "mysql", "mysql");  
            stt = con.createStatement();  
            
            ResultSet resultSet = stt.executeQuery("SELECT * FROM class101");  
            
            System.out.println("STUDENT NAME	ID	GRADE\n");  
            while (resultSet.next()) {  
                System.out.println(resultSet.getString("name") +"		"+resultSet.getString("id") +"	"+resultSet.getString("gpa"));  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{
        	con.close();
        }
		

	}
	
	
	

}
