package com.cts.dao;

import java.util.List;

import com.cts.beans.CourseBean;
import com.cts.beans.StudentBean;

public interface StudentDao {
	
	
	public int registerStudent(StudentBean student);
	
	public StudentBean validateStudent(String username,String password);
	
	public boolean updateStudent(StudentBean student);

	public boolean enroll(int roll,String cname);
	
	public List<CourseBean> getEnrolledCourses(int roll);
	
	
	
	
	
}
