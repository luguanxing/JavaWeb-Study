package jpa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/list2")
	public ModelAndView list2(Book book){
		ModelAndView mav=new ModelAndView();
		List<Book> bookList = bookDao.findAll(new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (book != null) {
					if (book.getName() != null && !book.getName().isEmpty()) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+book.getName()+"%"));
					}
					if(book.getAuthor()!=null && !"".equals(book.getAuthor())){
						predicate.getExpressions().add(cb.like(root.get("author"), "%"+book.getAuthor()+"%"));
					}
				}
				return predicate;
			}
		});
		mav.addObject("bookList", bookList);
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

	@GetMapping("/queryByName")
	@ResponseBody
	public List<Book> queryByName(){
		return bookDao.findByName("编程");
	}
	
	@GetMapping("/getOne")
	@ResponseBody
	public List<Book> randomSelectOne(){
		return bookDao.randomSelectOne();
	}
	
}
