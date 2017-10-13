package mapper;

import java.util.List;

import pojo.QueryVo;
import pojo.User;

public interface UserMapper {
	
	//动态代理开发只写接口，不写实现类
	//要求命名空间，方法名，返回值，参数要一致
	public User findById(Integer id);
	
	public List<User> findUserByQueryVo(QueryVo vo);

}
