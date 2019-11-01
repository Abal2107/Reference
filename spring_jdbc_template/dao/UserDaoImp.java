package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pojo.User;

public class UserDaoImp {
//	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTempateObj;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public void create(String fullname, String email,String username, String password) {
		jdbcTempateObj = new JdbcTemplate(dataSource);		
		String sql = "insert into user(name, email, username, password) values(?,?,?,?)";
		jdbcTempateObj.update(sql, fullname, email, username, password);
		
		
	}
	
	public User getUser(String username)
	{
		
		jdbcTempateObj = new JdbcTemplate(dataSource);
		String SQL = "select * from user where username = ?";
		
		User user = jdbcTempateObj.queryForObject(SQL, new Object[] {username}, new UserMapper());
		return user;
	}
	
	public List<User> ListUser()
	{
		jdbcTempateObj = new JdbcTemplate(dataSource);
		return jdbcTempateObj.query("select * from user", new UserMapper());
	}

	public void delete(String username)
	{
		jdbcTempateObj = new JdbcTemplate(dataSource);
		String sql = "delete from user where username = ?";
		jdbcTempateObj.update(sql, username);
		
		System.out.println("record deleted by the username = "+username);
	}
	
	
	public void update(String username, String password)
	{
		jdbcTempateObj = new JdbcTemplate(dataSource);
		String sql = "update user set password = ? where username = ?";
		jdbcTempateObj.update(sql,password, username );
		System.out.println("updated password for username "+username);

	}
	
	
}

	



