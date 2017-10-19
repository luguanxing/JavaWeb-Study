package controller;

import java.util.ArrayList;
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
	
}
