package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class CRUD操作 {

	@Test
	public void create() {
		//创建对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//操作jdbcTemplate对象的方法实现操作
		String sql = "INSERT INTO t_user VALUES(?, ?)";
		int rows = jdbcTemplate.update(sql, "add_test", "12345678");
		System.out.println(rows);
	}
	
	@Test
	public void retrieve() {
		//创建对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//操作jdbcTemplate对象的方法实现操作
		//1.查询返回基本数据类型(int, String等)
		String sql = "SELECT COUNT(*) FROM t_user";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("[SELECT COUNT(*) FROM t_user] -> " + count);
		
		//2.查询返回对象，需要手动使用RowMapper封装对象
		sql = "SELECT * FROM t_user WHERE username = ?";
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				return user;
			}
		}, "mary");
		System.out.println("[SELECT * FROM t_user WHERE username = ?] -> " + user);
		
		//3.查询返回List
		sql = "SELECT * FROM t_user";
		List users = jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				return user;
			}
		});
		System.out.println("[SELECT * FROM t_user] -> " + users);
	}
	
	@Test
	public void update() {
		//创建对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//操作jdbcTemplate对象的方法实现操作
		String sql = "UPDATE t_user SET password = ? WHERE username = ?";
		int rows = jdbcTemplate.update(sql, "23333333", "add_test");
		System.out.println(rows);
	}
	
	
	@Test
	public void delete() {
		//创建对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//操作jdbcTemplate对象的方法实现操作
		String sql = "DELETE FROM t_user WHERE username = ?";
		int rows = jdbcTemplate.update(sql, "add_test");
		System.out.println(rows);
	}
	
}
