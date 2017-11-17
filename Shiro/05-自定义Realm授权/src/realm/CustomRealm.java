package realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {
	
	//设置Realm名称
	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}

	//用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//从token取出凭证
		Object userPrincipal = token.getPrincipal();
		
		//模拟从数据库获取口令
		String credentials = "admin";
		
		//进行凭证和口令验证,失败返回NULL,查到返回检验结果
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userPrincipal, credentials, this.getName());
		
		return simpleAuthenticationInfo;
	}
	
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从principals取出身份信息
		//用getPrimaryPrincipal转为真实身份,在doGetAuthenticationInfo填充
		Object userPrincipal = principals.getPrimaryPrincipal();
		
		//模拟从数据库获取权限信息,假设该subject仅包含my_permission权限不
		List<String> permissions = new ArrayList<>();
		permissions.add("my_permission");
		
		//返回授权信息
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		
		return simpleAuthorizationInfo;
	}

}
