package jpa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jpa.dao.BookDao;
import jpa.entity.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	@Resource
	private BookDao bookDao;
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookList", bookDao.findAll());
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView get(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", bookDao.getOne(id));
		mav.setViewName("update");
		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Book book) {
		bookDao.save(book);
		return "forward:/book/list";
	}
	
	@PostMapping("/update")
	public String update(Book book) {
		bookDao.save(book);
		return "forward:/book/list";
	}
	
	@GetMapping("/delete")
	public String delete(Integer id) {
		bookDao.delete(id);
		return "forward:/book/list";
	}
	
}
