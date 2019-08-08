package com.cts.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.beans.CourseBean;
import com.cts.dao.CourseDaoFactory;

/**
 * Servlet implementation class GetCourseDetailsSrv
 */
@WebServlet("/GetCourseDetailsSrv")
public class GetCourseDetailsSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourseDetailsSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cname=request.getParameter("cname");
		
		CourseBean course=CourseDaoFactory.getCourseDao().getCourseDetails(cname);
		
		request.getSession().setAttribute("coursedata", course);
		
		response.sendRedirect("courseDetails.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
