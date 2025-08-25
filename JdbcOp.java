package aug20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcOp {

		// TODO Auto-generated method stub
		private static final String URL="jdbc:mysql://localhost:3306/abcd";
		private static final String USERNAME="root";
		private static final String PASSWORD ="sqlpragati2@";
		
		static Connection connection=null ;
		
		
		public static Connection getConnection()
		{
			try
			{
				return DriverManager.getConnection(URL,USERNAME,PASSWORD);
				
			}catch(SQLException e)
			{
				System.err.println("unable to connect to mysql sever"+e.getMessage());
				
			}
			return connection;
			
		}
		
		
		public static void closeConnection(Connection connection)
		{
			if(connection!=null)
			{
				try {
					connection.close();
					
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
	}
		
}

