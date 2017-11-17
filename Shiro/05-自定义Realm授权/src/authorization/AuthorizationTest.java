package authorization;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthorizationTest {

	//基于角色授权、基于资源授权测试
	@Test
	public void testAuthorization() {
		//创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
		
		//创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		//将SecurityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//创建subject
		Subject subject = SecurityUtils.getSubject();
		
		//执行认证
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//检测认证是否通过,通过则授权
		boolean isAuthenticated = false;
		isAuthenticated = subject.isAuthenticated();
		System.out.println("是否认证通过？" + isAuthenticated);
		
		//基于角色的授权,传入角色的标识
		boolean hasRole1 = subject.hasRole("role1");
		boolean hasRole1_2 = subject.hasAllRoles(Arrays.asList("role1", "role2"));
		boolean hasRole1_2_3 = subject.hasAllRoles(Arrays.asList("role1", "role2", "role3"));
		System.out.println("hasRole1 = " + hasRole1);
		System.out.println("hasRole1_2 = " + hasRole1_2);
		System.out.println("hasRole1_2_3 = " + hasRole1_2_3);
		
		//基于资源的授权,传入权限的标识
		boolean isPermitted_create = subject.isPermitted("user:create");
		boolean isPermitted_update = subject.isPermitted("user:update");
		boolean isPermitted_all = subject.isPermittedAll("user:create", "user:update", "user:delete");
		System.out.println("isPermitted_create = " + isPermitted_create);
		System.out.println("isPermitted _update = " + isPermitted_update);
		System.out.println("isPermitted_all = " + isPermitted_all);
		
		try {
			subject.checkPermission("user:create");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//测试自定义Realm授权
	@Test
	public void testRealm() {
		//创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		
		//创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		//将SecurityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//创建subject
		Subject subject = SecurityUtils.getSubject();
		
		//执行认证
		UsernamePasswordToken token = new UsernamePasswordToken("123", "admin");
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//检测认证是否通过,不通过后面一定权限不足(也不会从数据库判断权限)
		boolean isAuthenticated = false;
		isAuthenticated = subject.isAuthenticated();
		System.out.println("是否认证通过？" + isAuthenticated);
		
		//检测基于资源的授权,传入权限的标识,它会调用Realm的doGetAuthorizationInfo判断subject是否拥有该权限
		boolean unknown_permission = subject.isPermitted("unknown_permission");
		boolean my_permission = subject.isPermitted("my_permission");
		System.out.println("unknown_permission = " + unknown_permission);
		System.out.println("my_permission = " + my_permission);
	}
	
}
