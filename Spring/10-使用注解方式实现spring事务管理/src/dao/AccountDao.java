package dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component(value="accountDao")
public class AccountDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public void addMoney(String username, int value) {
		String sql = "UPDATE t_account SET money = money + ? WHERE username = ?";
		jdbcTemplate.update(sql, value, username);
	}
	
	public void subMoney(String username, int value) {
		String sql = "UPDATE t_account SET money = money - ? WHERE username = ?";
		jdbcTemplate.update(sql, value, username);
	}
	
}
