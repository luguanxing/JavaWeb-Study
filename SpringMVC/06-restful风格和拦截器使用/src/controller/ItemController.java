package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import exception.MyException;
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
	
	//修改功能，绑定参数为Items，解决post乱码问题
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Items items) {
		itemsService.editItemsById(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//使用包装pojo类绑定参数，保存上传图片
	@RequestMapping(value = "/editByVo")
	public ModelAndView editByVo(QueryVo vo, MultipartFile uploadPicture) throws Exception {
		//保存图片
		String ext = FilenameUtils.getExtension(uploadPicture.getOriginalFilename());
		String filename = UUID.randomUUID().toString().replaceAll("-", "");
		uploadPicture.transferTo(new File("D:\\upload\\" + filename + "." + ext));
		vo.getItems().setPic(filename + "." + ext);
		vo.getItems().setCreatetime(new Date());
		//保存表单
		itemsService.editItemsById(vo.getItems());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//删除多个
	@RequestMapping(value = "/delete")
	public ModelAndView delete(Integer[] ids) {
		System.out.println(Arrays.toString(ids));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//使用包装pojo类删除多个
	@RequestMapping(value = "/deleteByVo")
	public ModelAndView deleteByVo(QueryVo vo) {
		System.out.println(Arrays.toString(vo.getIds()));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//使用包装pojo类修改多个(注意springmvc)只能用包装类实现List 
	@RequestMapping(value = "/editListByVo")
	public ModelAndView editListByVo(QueryVo vo) {
		System.out.println(vo.getItemsList());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	//重定向
	@RequestMapping(value = "/redirect")
	public String redirect() {
		return "redirect: /list";
	}
	
	//转发
	@RequestMapping(value = "/forward")
	public String forward() {
		return "forward:/list";
	}
	
	//错误测试
	@RequestMapping(value = "/errortest")
	public String errortest() throws MyException {
		//Integer i = 1/0;
		throw new MyException("错误测试信息");
		//return "forward:/list";
	}
	
	//json数据交互
	@RequestMapping(value = "/json")
	public @ResponseBody Items json(@RequestBody Items items) {
		System.out.println(items);
		return items;
	}
	
	//restful风格开发:restful/id直接去edit页面，@PathVariable表明路径上有变量
	@RequestMapping(value = "/restful/{id}")
	public ModelAndView restful(@PathVariable Integer id) {
		Items items = itemsService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}
	
	//登录页面
	@RequestMapping(value = "/loginUI")
	public String loginUI() {
		return "login";
	}
	
	//登录方法(和loginUI方法区分，也可以用method=RequestMethod.GET/POST区分)
	@RequestMapping(value = "/login")
	public String login(String token, HttpSession session) {
		if ("admin".equals(token))
				session.setAttribute("admin", "admin");
		return "redirect:list";
	}
	
}
