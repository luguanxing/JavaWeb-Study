package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class FreeMarkerController {

	@RequestMapping("/page")
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "1234567");
		mav.setViewName("freedmarkpage");
		return mav;
	}
	
}
