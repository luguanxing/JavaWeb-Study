package junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mapper.UserMapper;
import pojo.User;

public class service {

	@Test
	public void test() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//让sqlSession来生成实现类,直接只使用接口
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findById(10);
		System.out.println(user);
	}
	
}
