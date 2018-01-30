package aop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import aop.entity.Student;

/**
 * 学生信息Dao接口
 * @author Administrator
 *
 */
public interface StudentDao extends JpaRepository<Student, Integer>{

}
