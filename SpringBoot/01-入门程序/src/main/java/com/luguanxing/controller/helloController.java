package com.luguanxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
 
	@ResponseBody
	@RequestMapping("hello")
	public String sayHello() {
		return "spring-boot hello world";
	}
	
}
