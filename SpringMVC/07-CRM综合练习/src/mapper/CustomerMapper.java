package mapper;

import java.util.List;

import pojo.BaseDict;
import pojo.Customer;
import pojo.QueryVo;

public interface CustomerMapper {
	
	//查符合条件的总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	
	//查符合条件的数据结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);

	//通过ID修改客户
	public void editCustomerById(Customer customer);

	//通过ID删除客户
	public void deleteCustomerById(Integer id);
		
}
