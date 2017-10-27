package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import user.entity.User;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User resultUser = userService.login(user);
		if (resultUser == null) {
			request.setAttribute("user", null);
			request.setAttribute("errorMsg", "用户名或密码错误");
			return "index";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", resultUser);
			return "success";
		}
	}
	
}
