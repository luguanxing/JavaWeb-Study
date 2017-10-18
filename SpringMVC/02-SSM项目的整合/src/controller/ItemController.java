package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Items;
import service.ItemsService;

@Controller
public class ItemController {

	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(value = "/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		
		//从mysql中获取数据
		List<Items> list = itemsService.selectItemsList();

		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	
}
