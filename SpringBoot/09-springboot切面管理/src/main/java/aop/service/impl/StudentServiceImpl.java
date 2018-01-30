package aop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aop.dao.StudentDao;
import aop.entity.Student;
import aop.service.StudentService;



/**
 * 学生信息Service实现类
 * @author Administrator
 *
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	@Resource
	private StudentDao studentDao;
	
	@Override
	public void add(Student student) {
		studentDao.save(student);
	}

}
