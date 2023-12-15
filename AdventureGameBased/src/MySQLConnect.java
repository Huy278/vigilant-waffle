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
        String url = "jdbc:mysql://localhost:3306/" + db;

        try {
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
}