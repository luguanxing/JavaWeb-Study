package validdata.service;

import validdata.entity.Student;

/**
 * 学生信息Service接口
 * @author Administrator
 *
 */
public interface StudentService {

	/**
	 * 添加学生信息
	 * @param student
	 */
	public void add(Student student);
}

