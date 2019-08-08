package com.cts.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.beans.CourseBean;
import com.cts.dao.StudentDao;
import com.cts.dao.StudentDaoFactory;

/**
 * Servlet implementation class GetEnrollCourseSrv
 */
@WebServlet("/GetEnrollCourseSrv")
public class GetEnrollCourseSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEnrollCourseSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String roll=request.getParameter("roll");
		
		int roll1=Integer.parseInt(roll.trim());
		
		
		StudentDao dao=StudentDaoFactory.getStudentDao();
		
		List<CourseBean> courseList=dao.getEnrolledCourses(roll1);
		
	request.getSession().setAttribute("coursedata", courseList);
	
	response.sendRedirect("displyCourses.jsp");
		
		
		
		
		
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
