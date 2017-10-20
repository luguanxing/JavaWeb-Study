package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//自定义异常处理器实现类
public class MyExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) {
		//obj是发生异常的地方(如Service):包名+类名+方法名的字符串
		//一般处理是写异常日志
		ModelAndView mav = new ModelAndView();
		//判断是否为预期异常
		if (e instanceof MyException) {
			mav.addObject("errormsg", "[预期异常] -> " + ((MyException)e).getMyMsg());
			mav.setViewName("error");
		} else {
			mav.addObject("errormsg", "[未知异常] -> " + e.getMessage());
			mav.setViewName("error");
		}
		return mav;
	}

}
