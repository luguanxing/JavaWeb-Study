package mapper;

import java.util.List;

import pojo.QueryVo;
import pojo.User;

public interface UserMapper {
	
	//动态代理开发只写接口，不写实现类
	//要求命名空间，方法名，返回值，参数要一致
	public User findById(Integer id);
	
	//使用queryvo进行用户名模糊查询
	public List<User> findUserByQueryVo(QueryVo vo);
	
	//根据性别和名字查询用户
	public List<User> selectUserBySexAndUsername(User user);

	//查询多个ID
	public List<User> selectUserByIds(Integer[] ids);
	public List<User> selectUserByIdsList(List<Integer> list);
	public List<User> selectUserByVoIds(QueryVo vo);
	public List<User> selectUserByVoIdsList(QueryVo vo);
	
	
}
