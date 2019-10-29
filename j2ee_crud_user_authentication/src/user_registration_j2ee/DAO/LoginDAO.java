package user_registration_j2ee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public String checkpass(String username)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement preparedStatement  = null;
		String pass="";
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","neonowl");
			String check_user = "select password from user where username = ?";
			PreparedStatement pst  = conn.prepareStatement(check_user); 
			pst.setString(1, username);
			
			ResultSet rs = pst.executeQuery();
			 while(rs.next())
			 {
				 pass  = rs.getString("password");
			 }
			
			 rs.close();
			 pst.close();
			 conn.close();
			 
			return pass;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
			return "wrong";
	}

}
