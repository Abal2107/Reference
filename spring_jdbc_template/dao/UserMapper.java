package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pojo.User;

public class UserMapper implements RowMapper<User>{
	
	public User mapRow(ResultSet rs, int rownum) throws SQLException
	{
		User user = new User();
		user.setFullname(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		
		
		return user;
	}
	

}
