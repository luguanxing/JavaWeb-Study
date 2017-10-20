package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import exception.MyException;
import pojo.Items;
import pojo.QueryVo;
import service.ItemsService;

@Controller
public class ItemController {

	@Autowired
	private ItemsService itemsService;
	
	//列表功能
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Items> list = itemsService.selectItemsList();
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	
	//去编辑页面，传入id(可自定义传入名,处理null，设置默认值)，也可传入其它参数： HttpServletRequest, HttpServletResponse, HttpSession, Model
	@RequestMapping(value = "/editUI")
	public ModelAndView editUI(@RequestParam(value="id", required=false, defaultValue="1")Integer id) {
		Items items = itemsService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}
	
	//修改功能,绑定参数为Items，解决post乱码问题
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Items items) {
		itemsService.editItemsById(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//使用包装pojo类绑定参数
	@RequestMapping(value = "/editByVo")
	public ModelAndView editByVo(QueryVo vo) {
		itemsService.editItemsById(vo.getItems());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//删除多个
	@RequestMapping(value = "/delete")
	public ModelAndView delete(Integer[] ids) {
		System.out.println(Arrays.toString(ids));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//使用包装pojo类删除多个
	@RequestMapping(value = "/deleteByVo")
	public ModelAndView deleteByVo(QueryVo vo) {
		System.out.println(Arrays.toString(vo.getIds()));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//使用包装pojo类修改多个(注意springmvc)只能用包装类实现List 
	@RequestMapping(value = "/editListByVo")
	public ModelAndView editListByVo(QueryVo vo) {
		System.out.println(vo.getItemsList());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//重定向
	@RequestMapping(value = "/redirect")
	public String redirect() {
		return "redirect:/list";
	}
	
	//转发
	@RequestMapping(value = "/forward")
	public String forward() {
		return "forward:/list";
	}
	
	//错误测试
	@RequestMapping(value = "/errortest")
	public String errortest() throws MyException {
		//Integer i = 1/0;
		throw new MyException("错误测试信息");
		//return "forward:/list";
	}
	
}
