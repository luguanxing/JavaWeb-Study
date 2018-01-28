package jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.entity.Book;

public interface BookDao extends JpaRepository<Book	, Integer> {

}
