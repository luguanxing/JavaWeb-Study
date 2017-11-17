package authentication;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class MD5test {
	
	@Test
	public void testMD5() {
		//明文
		String source = "admin";
		
		//盐
		String salt = "salt";
		
		//散列次数
		 int hashIterations = 2;
		
		 //输出结果
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		String target = md5Hash.toString();		
		System.out.println(target);
	}

	
	
	@Test
	public void testHash() {
		//明文
		String source = "123";
		
		//盐
		String salt = "";
		
		//散列次数
		 int hashIterations = 1;
		
		 //输出结果
		SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
		String target = simpleHash.toString();		
		System.out.println(target);
	}
	
	
}
