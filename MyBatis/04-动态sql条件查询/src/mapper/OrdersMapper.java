package mapper;

import java.util.List;

import pojo.Orders;
import pojo.QueryVo;
import pojo.User;

public interface OrdersMapper {
	
	public List<Orders> selectOrdersList();

}
