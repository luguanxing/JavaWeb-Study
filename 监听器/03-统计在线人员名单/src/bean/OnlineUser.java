package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/14.
 */
public class OnlineUser {
	
	private static OnlineUser instance = new OnlineUser();
	private static Map userMap = new HashMap();
	
	public static OnlineUser getInstance() {
		return instance;
	}
	
	public void addUser(User user) {
		userMap.put(user.getId(), user.getUsername());
	}

	public void removeUser(User user) {
		userMap.remove(user.getId());
	}
	
	public Map getOnlineUsers() {
		return userMap;
	}
	
}
