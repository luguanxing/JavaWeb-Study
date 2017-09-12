package entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	
  	private Integer user_id;//用户id
  	private String user_name;//用户名称
  	private String user_password;//用户密码
  	
  	//一个用户可作为多个角色
  	private Set<Role> asRole = new HashSet<Role>();
	public Set<Role> getAsRole() {
		return asRole;
	}
	public void setAsRole(Set<Role> asRole) {
		this.asRole = asRole;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
  	
}
