package junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mapper.OrdersMapper;
import mapper.UserMapper;
import pojo.Orders;
import pojo.QueryVo;
import pojo.User;

public class service {

	@Test
	public void testQueryVo() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//让sqlSession来生成实现类,直接只使用接口
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("a");
		vo.setUser(user);
		
		List<User> users = userMapper.findUserByQueryVo(vo);
		for (User u : users) {
			System.out.println(u);
		}
	}
	
	
	@Test
	public void testResultMap() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<Orders> list = ordersMapper.selectOrdersList();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}
	
}
