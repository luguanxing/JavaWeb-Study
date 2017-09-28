package property;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserService {
	
	private UserDao userDao;
	private String[] strings;
	private List<String> list;
	private Map<String, String> map;
	private Properties properties;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setList(List<String> list) {
		this.list = list;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void add() {
		System.out.println("UserService->add");
		UserDao dao = new UserDao();
		dao.add();
		System.out.println("strings[] = " + Arrays.toString(strings));
		System.out.println("list = " + list);
		System.out.println("map = " + map);
		System.out.println("properties = " + properties);
	}
	
}
