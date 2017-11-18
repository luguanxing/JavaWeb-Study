package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import entity.User;

public class UserDao {

	public User getByUserName(Connection con,String username) throws Exception {
		User resultUser=null;
		String sql="select * from t_user where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}

	public Set<String> getRoles(Connection con, String userName) throws Exception {
		Set<String> roles=new HashSet<String>();
		String sql="select * from t_user u,t_role r where u.roleId=r.id and u.userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			String roleName = rs.getString("roleName");
			String[] roleNames = roleName.split(",");	//简化了中间表,所以表项用逗号分隔
			for (String role : roleNames) {
				roles.add(role);
			}
		}
		return roles;
	}

	public Set<String> getPermissions(Connection con, String userName) throws Exception {
		Set<String> permissions=new HashSet<String>();
		String sql="select * from t_user u,t_role r,t_permission p where u.roleId=r.id and p.roleId=r.id and u.userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			String permissionName = rs.getString("permissionName");
			String[] permissionNames = permissionName.split(",");
			for (String permission : permissionNames) {
				permissions.add(permission);
			}
		}
		return permissions;
	}
	
}
