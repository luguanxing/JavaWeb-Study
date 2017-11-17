package realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
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
		
		return null;
	}

}
