package c3p0;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component(value="userDao")
public class UserDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public void add() {
		System.out.println("Dao->add");
		String sql = "INSERT INTO t_user VALUES(?, ?)";
		jdbcTemplate.update(sql, "·Ê·Ê", "333");
	}
	
}
