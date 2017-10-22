package service;

import java.util.List;

import pojo.Customer;
import pojo.QueryVo;
import utils.Page;

public interface CustomerService {

	//查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	
	//通过ID修改客户
	public void editCustomerById(Customer customer);

	//通过ID删除客户
	public void deleteCustomerById(Integer id);
	
}
