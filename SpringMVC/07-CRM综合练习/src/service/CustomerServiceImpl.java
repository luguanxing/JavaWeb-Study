package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.CustomerMapper;
import pojo.Customer;
import pojo.QueryVo;
import utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		vo.setSize(6);
		page.setSize(6);
		if (vo != null) {
			if (vo.getPage() != null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if (vo.getCustName() != null && !vo.getCustName().trim().isEmpty()) {
				vo.setCustName(vo.getCustName().trim());
			}
			if (vo.getCustSource() != null && !vo.getCustSource().trim().isEmpty()) {
				vo.setCustSource(vo.getCustSource().trim());
			}
			if (vo.getCustIndustry() != null && !vo.getCustIndustry().trim().isEmpty()) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if (vo.getCustLevel() != null && !vo.getCustLevel().trim().isEmpty()) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			page.setTotal(customerMapper.customerCountByQueryVo(vo));
			page.setRows(customerMapper.selectCustomerListByQueryVo(vo));
		}
		return page;
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		return customerMapper.selectCustomerById(id);
	}

	@Override
	public void editCustomerById(Customer customer) {
		customerMapper.editCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}

}
