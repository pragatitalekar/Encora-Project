package aug20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbOperations {

	public static int insertInfo(int product_id, String product_name, int price) {
		Connection jdbc_connaction=JdbcOp.getConnection();
		// TODO Auto-generated method stub
		
		int rowsEffected = 0;
		try {
			PreparedStatement ps=jdbc_connaction.prepareStatement("insert into Products (product_id, product_name, price) values(?,?,?)");
			ps.setInt(1, product_id);
			ps.setString(2, product_name);
			ps.setLong(3, price);
			rowsEffected = ps.executeUpdate();
//			System.out.println(rowsEffected+" rows are added successfully");
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		JdbcOp.closeConnection(jdbc_connaction);
		return rowsEffected;
		}
	
	public static void displayInfo() {
		Connection jdbc_connaction=JdbcOp.getConnection();
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=jdbc_connaction.prepareStatement("Select * from Products");
			ResultSet result=ps.executeQuery();
			
			while(result.next()) {
				String product_id = result.getString("product_id");
				String product_name =result.getString("product_name");
				int price=result.getInt("price");
				System.out.printf("product id: "+product_id+"\n product name: "+ product_name+ "\n price: "+ price+"\n \n");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcOp.closeConnection(jdbc_connaction);
	
	}
	
	public static int deleteQry(String product_name) {
		Connection jdbc_connaction=JdbcOp.getConnection();
		// TODO Auto-generated method stub
		int rowsEffected = 0;
		try {
			PreparedStatement ps=jdbc_connaction.prepareStatement("delete from Products where product_name = ?");
			ps.setString(1, product_name);
			rowsEffected =  ps.executeUpdate();
			
			if(rowsEffected > 0) {
//				System.out.println(rowsEffected+ " rows are deleted from the table");
			}
			else {
				System.out.println("No rows are affected and delete operation did not execute");
			}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return rowsEffected;
	}
}
