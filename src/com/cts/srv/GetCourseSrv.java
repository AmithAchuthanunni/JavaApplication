package com.cts.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.beans.CourseBean;
import com.cts.dao.CourseDao;
import com.cts.dao.CourseDaoFactory;

/**
 * Servlet implementation class GetCourseSrv
 */
@WebServlet("/GetCourseSrv")
public class GetCourseSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourseSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseDao dao=CourseDaoFactory.getCourseDao();
		
		List<CourseBean> courses=dao.getAllCourses();
		
		HttpSession ses=request.getSession();
		
		ses.setAttribute("coursesdata", courses);
		
		response.sendRedirect("getCourseDetails.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
