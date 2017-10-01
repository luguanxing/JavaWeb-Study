package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class CRUD���� {

	@Test
	public void create() {
		//���������������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//����jdbcTemplate����ķ���ʵ�ֲ���
		String sql = "INSERT INTO t_user VALUES(?, ?)";
		int rows = jdbcTemplate.update(sql, "add_test", "12345678");
		System.out.println(rows);
	}
	
	@Test
	public void retrieve() {
		//���������������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//����jdbcTemplate����ķ���ʵ�ֲ���
		//1.��ѯ���ػ�����������(int, String��)
		String sql = "SELECT COUNT(*) FROM t_user";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("[SELECT COUNT(*) FROM t_user] -> " + count);
		
		//2.��ѯ���ض�����Ҫ�ֶ�ʹ��RowMapper��װ����
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
		
		//3.��ѯ����List
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
		//���������������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//����jdbcTemplate����ķ���ʵ�ֲ���
		String sql = "UPDATE t_user SET password = ? WHERE username = ?";
		int rows = jdbcTemplate.update(sql, "23333333", "add_test");
		System.out.println(rows);
	}
	
	
	@Test
	public void delete() {
		//���������������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//����jdbcTemplate����ķ���ʵ�ֲ���
		String sql = "DELETE FROM t_user WHERE username = ?";
		int rows = jdbcTemplate.update(sql, "add_test");
		System.out.println(rows);
	}
	
}
