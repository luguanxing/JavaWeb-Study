package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/param")
public class ParamController {

	@RequestMapping("/{id}")
	public ModelAndView showParamUrl(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("idPage");
		return mav;
	}
	
	@RequestMapping("/query")
	public ModelAndView showParam(@RequestParam(value="para", required=false)String para) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("para", para);
		mav.setViewName("paraPage");
		return mav;
	}
	
}
