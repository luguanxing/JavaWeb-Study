package junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pojo.User;

public class CRUD {
	
	@Test
	public void findById() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//执行sql语句
		User user = session.selectOne("user_crud.findById", 10);
		System.out.println(user);
	}

	@Test
	public void findByUsername() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//执行sql语句
		List<User> users = session.selectList("user_crud.findByUsername", "五");
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void addUser() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//执行sql语句
		User user = new User();
		user.setUsername("aaa");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("ccc");
		
		int row = session.insert("user_crud.addUser", user);
		System.out.println(row);
		//注意要提交
		session.commit();
	}
	
	@Test
	public void addUserReturnId() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//执行sql语句
		User user = new User();
		user.setUsername("kkk");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("666");
		
		int row = session.insert("user_crud.addUserReturnId", user);
		System.out.println(row);
		System.out.println("id = " + user.getId());
		session.commit();
	}
	
	@Test
	public void updateUser() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//执行sql语句
		User user = new User();
		user.setId(1);
		user.setUsername("bbb");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("nnn");
		
		int row = session.insert("user_crud.updateUser", user);
		System.out.println(row);
		System.out.println(user);
		session.commit();
	}
	
	@Test
	public void deleteUser() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession session = factory.openSession();
		
		//执行sql语句
		int row = session.insert("user_crud.deleteUser", 33);
		System.out.println(row);
		session.commit();
	}
	
}
