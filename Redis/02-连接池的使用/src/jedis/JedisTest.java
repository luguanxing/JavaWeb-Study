package jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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
	
	@Test
	//通过jedis的连接池pool获取jedis连接对象
	public void testJedisPool() {
		//0.创建连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(30);	//最大闲置个数
		config.setMinIdle(10);	//最小闲置个数
		config.setMaxTotal(50);	//最大连接数
		
		//1.创建Redis的连接池
		JedisPool pool = new JedisPool(config, "192.168.244.129", 6379);
		
		//2.从连接池获取redis连接
		Jedis jedis = pool.getResource();
		
		//3.操作数据库
		jedis.set("xxx", "123");
		System.out.println(jedis.get("xxx"));
		
		//4.关闭资源,真正项目不用关连接池
		jedis.close();
		pool.close();
	}
}
