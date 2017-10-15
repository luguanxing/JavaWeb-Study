package junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
	public void testOrderOneToOne() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<Orders> list = ordersMapper.selectOrders();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	
	@Test
	public void testOrderOneToMany() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<User> users = ordersMapper.selectUsers();
		for (User user : users) {
			System.out.println(user);
		}
		
	}

}
