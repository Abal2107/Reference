package user_registration_j2ee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import user_registration_j2ee.beans.User;

public class RegisterDAO {
	
	public String registerUser(User user)
	{
		String fullName = user.getFullName();
		String email = user.getEmail() ;
		String username = user.getUserName() ;
		String password = user.getPassword();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement preparedStatement  = null;
		
		
		try {
			
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","neonowl");
			
			String inser_user = "insert into user(name, email, username , password) values(?,?,?,?)";
			preparedStatement = conn.prepareStatement(inser_user);
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			
			int i = preparedStatement.executeUpdate();
			
			if(i != 0)
				return "Success";
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "something went wrong";
		
	}

}
