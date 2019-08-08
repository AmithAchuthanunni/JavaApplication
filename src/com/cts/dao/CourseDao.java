package com.cts.dao;

import java.util.List;

import com.cts.beans.CourseBean;

public interface CourseDao {

	public boolean addNewCourse(CourseBean course);
	
	public List<CourseBean> getAllCourses();
	
	public CourseBean getCourseDetails(String cname);
	
	public int getCapacity(String cname);
	
	public int getAvailibility(String cname);
	
	public boolean updateCourse(CourseBean course);
	
}
