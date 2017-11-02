package jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {

	//通过java查询访问redis数据库
	
	@Test
	//获得单一jedis对象操作数据库
	public void testJedis() {
		//1.获取连接对象
		Jedis jedis = new Jedis("192.168.244.129", 6379);
		
		//2.获取数据
		String username = jedis.get("username");
		System.out.println(username);
		
		//3.存储数据
		jedis.set("addr", "地球");
		System.out.println(jedis.get("addr"));
	}
	

}
