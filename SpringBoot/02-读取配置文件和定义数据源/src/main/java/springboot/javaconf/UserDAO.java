package springboot.javaconf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO {

	@Autowired
	private DataSource dataSource; // 注入Spring容器中的bean对象(由SpringConfig里的Bean方法提供)
	
	public List<User> queryUserList() {
		List<User> list = new ArrayList();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			st = (Statement) conn.createStatement();
			rs = st.executeQuery("select * from t_user");
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getObject("username").toString());
				user.setPassword(rs.getObject("password").toString());
				user.setAge(Integer.parseInt(rs.getObject("id").toString()));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return list;
	}

}
