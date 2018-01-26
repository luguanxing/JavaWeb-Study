package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.properties.MySqlProperties;

@Controller
public class HelloController {

	@Value("${HELLO_STRING}")
	private String HELLO_STRING;
	
	@Autowired
	private MySqlProperties mySqlProperties;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		System.out.println(mySqlProperties.getJdbcName());
		System.out.println(mySqlProperties.getDbUrl());
		System.out.println(mySqlProperties.getUserName());
		System.out.println(mySqlProperties.getPassword());
		return HELLO_STRING;
	}
	
}
