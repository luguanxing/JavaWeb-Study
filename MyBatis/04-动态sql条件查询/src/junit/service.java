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
	public void testQueryBySexAndUsername() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//条件查询
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		//user.setUsername("张小明");
		List<User> users = userMapper.selectUserBySexAndUsername(user);
		for (User u : users) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testQueryByIds() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//多id查询
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		List<User> users;
		
		//使用Integer[]查多个ID
		Integer[] ids = {10, 16};
		users = userMapper.selectUserByIds(ids);
		for (User u : users) {
			System.out.println(u);
		}
		System.out.println("======================");
		
		//使用QueryVo的内置数组查多个ID
		vo.setIds(ids);
		users = userMapper.selectUserByVoIds(vo);
		for (User u : users) {
			System.out.println(u);
		}
		System.out.println("======================");
		
		//使用List查多个ID
		List<Integer> idsList = new ArrayList<>();
		idsList.add(10);
		idsList.add(16);
		idsList.add(22);
		users = userMapper.selectUserByIdsList(idsList);
		for (User u : users) {
			System.out.println(u);
		}
		System.out.println("======================");
		
		//使用QueryVo的内置List查多个ID
		vo.setIdsList(idsList);
		users = userMapper.selectUserByVoIdsList(vo);
		for (User u : users) {
			System.out.println(u);
		}
		System.out.println("======================");
	}
	
	
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
		user.setUsername("");
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
