package realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomRealmMD5 extends AuthorizingRealm {

	// 设置Realm名称
	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}

	// 用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 从token取出凭证
		Object userPrincipal = token.getPrincipal();

		// 模拟从数据库获取口令,与数据库中的口令md5(md5('admin'))=c5833cfad830db4350cc48af3e503db4比较
		String hashedCredentials = "c5833cfad830db4350cc48af3e503db4";
		String credentialsSalt = "salt";

		// 进行散列方式下凭证的口令验证,失败返回NULL,查到返回检验结果
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userPrincipal,
				hashedCredentials, ByteSource.Util.bytes(credentialsSalt), this.getName());

		return simpleAuthenticationInfo;
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		return null;
	}

}
