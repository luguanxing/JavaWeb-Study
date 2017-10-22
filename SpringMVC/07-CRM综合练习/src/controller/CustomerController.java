package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.BaseDict;
import pojo.Customer;
import pojo.QueryVo;
import service.BaseDictService;
import service.CustomerService;
import utils.Page;

//客户管理
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	//注解在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	
	//入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo, Model model) {
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		//通过4个条件查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);

		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}
	
	
	//编辑界面数据回显
	@RequestMapping(value="/customer/editUI")
	public @ResponseBody Customer editUI(Integer id) {
		return customerService.selectCustomerById(id);
	}
	
	//编辑数据
	@RequestMapping(value="/customer/edit")
	public @ResponseBody String edit(Customer customer) {
		customerService.editCustomerById(customer);
		//要返回data使ajax向下执行
		return "OK";
	}
	
	//删除数据
	@RequestMapping(value="/customer/delete")
	public @ResponseBody String delete(Integer id) {
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
}
