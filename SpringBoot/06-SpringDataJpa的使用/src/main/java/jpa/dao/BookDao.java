package jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import jpa.entity.Book;

public interface BookDao extends JpaRepository<Book	, Integer>, JpaSpecificationExecutor<Book> {

	//HQL语法，不推荐
	@Query("SELECT book FROM Book book WHERE book.name LIKE %?1%")
	public List<Book> findByName(String bookname);
	
	//SQL语法，推荐
	@Query(value="SELECT * FROM book ORDER BY RAND() LIMIT 1", nativeQuery=true)
	public List<Book> randomSelectOne();
	
}
