package Factory;
import java.sql.*;
public class ConnectionFactory 
{	
	private static final String USERNAME = "ti2cc";
	private static final String PASSWORD = "ti@cc";
	private static final String URL = "jdbc:postgresql://localhost:5432/cliente";
	
public static Connection createConnectionToMYSQL() throws SQLException, Exception {
		
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		 System.out.println("\nConnected!\n");
		return connection;
	}
	
	public static void main(String[] args) throws Exception
	{
		Connection con = createConnectionToMYSQL();
		
		if(con != null)
		{
			System.out.println("Connected");
			con.close();
		}
	}


	
}
