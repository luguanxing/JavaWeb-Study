package com.luguanxing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luguanxing.pojo.Product;
import com.luguanxing.service.JdService;

@Controller
public class JdController {

	@Autowired
	private JdService jdService;
	
	//商品列表
	@RequestMapping(value="list.action")
	public String list(String queryString, String price, String sort, Model model) throws Exception {
		List<Product> products = jdService.selectedProductListByQuery(queryString, price, sort);
		model.addAttribute("productModels",products);
		model.addAttribute("queryString",queryString);
		model.addAttribute("price",price);
		model.addAttribute("sort",sort);
		return "product_list";
	}
	
	
}
