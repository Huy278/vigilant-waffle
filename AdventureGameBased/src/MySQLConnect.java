import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {
    // Properties of the MySQLConnection Class
	Connection connection = null;
	Statement statement = null;
    public MySQLConnect(String db) {
    	
        String url = "jdbc:mysql://localhost:3306/"+db;

        try {
            System.out.println("0");
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "Keefe2012");
            statement = connection.createStatement();

       }
       catch (Exception e) {
            System.out.println(e);
        }    
    }
   
    public ResultSet select(String sql) {
        ResultSet resultSet = null;
        
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public Object[][] unpackEnemyDatabase(){
    	ResultSet results;
    	int height = 0;
    	try {
    	results=statement.executeQuery("select count(id) from enemy;");
    	
		
    	while (results.next()) {
			height = results.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Object[][] arr = new Object[height][5];
    	int i = 0;
    	try {
    		results=statement.executeQuery("select * from enemy;");
			while (results.next()) {
					arr[i][0] = results.getString(2);
					arr[i][1] = results.getInt(3);
					arr[i][2] = results.getDouble(4);
					arr[i][3] = results.getInt(5);
					arr[i][4] = results.getInt(6);
					i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return arr;
    }
}
