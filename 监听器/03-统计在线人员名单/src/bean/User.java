package bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by Administrator on 2017/8/14.
 */
public class User implements HttpSessionBindingListener {
	
	private String username;
	private String password;
	private String id;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
		//被绑定到session时增加全局Map用户
		OnlineUser.getInstance().addUser(this);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		//被移除出session时增减少全局Map用户
		OnlineUser.getInstance().removeUser(this);
	}
}
