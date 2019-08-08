package com.cts.dao;

public class CourseDaoFactory {
	
	private static CourseDao dao;
	
	
	static{
		
		dao=new CourseDaoImpl();
	}

	public static CourseDao getCourseDao(){
		return dao;
	}
	
	
	
}
