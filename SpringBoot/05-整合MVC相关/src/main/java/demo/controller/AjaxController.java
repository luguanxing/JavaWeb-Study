package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController	//相当于内部方法都加上了@ResponseBody
@RequestMapping("/ajax")
public class AjaxController {

	@RequestMapping("/hello")
	public String hello() {
		return "{'message1':'hello', 'message2', 'hi'}";
	}
	
}
