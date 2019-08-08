package com.cts.dao;

public class StudentDaoFactory {
	
	
	private static StudentDao dao;
	
	
	static{
		dao=new StudentDaoImpl();
	}

	public static StudentDao getStudentDao(){
		return dao;
	}
	
	
	
}
