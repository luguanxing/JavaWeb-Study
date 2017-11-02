package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

	private static JedisPool pool = null;
	
	static {
		//加载配置文件
		InputStream in = Jedis.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//创建连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(Integer.parseInt(pro.getProperty("redis.maxIdle")));		//最大闲置个数
		config.setMinIdle(Integer.parseInt(pro.getProperty("redis.minIdle")));		//最小闲置个数
		config.setMaxTotal(Integer.parseInt(pro.getProperty("redis.maxTotal")));	//最大连接数
		pool = new JedisPool(config, pro.getProperty("redis.url"), Integer.parseInt(pro.getProperty("redis.port")));
	}
	
	//获取jedis资源
	public static Jedis getJedis() {
		return pool.getResource();
	}
	
	//关闭jedis资源
	public static void closeJedis(Jedis jedis) {
		jedis.close();
	}
	
	public static void main(String[] args) {
		Jedis jedis = getJedis();
		System.out.println(jedis.get("xxx"));
		closeJedis(jedis);
	}

}
