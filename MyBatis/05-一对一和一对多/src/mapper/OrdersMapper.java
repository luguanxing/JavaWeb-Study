package mapper;

import java.util.List;

import pojo.Orders;
import pojo.QueryVo;
import pojo.User;

public interface OrdersMapper {
	
	//以订单为中心一对一关联查询
	public List<Orders> selectOrders();
	
	//以用户为中心一对多关联查询
	public List<User> selectUsers();

}
