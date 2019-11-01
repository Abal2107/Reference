package dao;

import java.util.List;

import javax.sql.DataSource;

import pojo.User;

public interface UserDao {
	
	public void setDataSource(DataSource ds);
	
	public void create(String fullname, String email, String username, String password);
	
	public User getUser(String Username);
	
	public List<User> ListUser();
	
	public void delete(String username);
	
	public void update(String username, String password);
	
	

}
