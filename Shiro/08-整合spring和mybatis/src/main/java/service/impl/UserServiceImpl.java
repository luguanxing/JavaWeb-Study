package service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public User getByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		Set<String> roles=new HashSet<String>();
		String role_strs_all = userDao.getRoles(userName);
		if (role_strs_all != null) {
			String[] role_strs = role_strs_all.split(",");
			for (String role_str : role_strs) {
				roles.add(role_str);
			}
		}
		return roles;
	}

	public Set<String> getPermissions(String userName) {
		Set<String> permissions=new HashSet<String>();
		String permission_strs_all = userDao.getPermissions(userName);
		if (permission_strs_all != null) {
			String[] permission_strs = permission_strs_all.split(",");
			for (String permission_str : permission_strs) {
				permissions.add(permission_str);
			}
		}
		return permissions;
	}

}
