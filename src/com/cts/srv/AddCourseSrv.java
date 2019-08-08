package com.cts.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.beans.CourseBean;
import com.cts.dao.CourseDao;
import com.cts.dao.CourseDaoFactory;

/**
 * Servlet implementation class AddCourseSrv
 */
@WebServlet("/AddCourseSrv")
public class AddCourseSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cname=request.getParameter("cname");
		String cfee=request.getParameter("cfee");
		String cduration=request.getParameter("cduration");
		String ccapacity=request.getParameter("ccapacity");
		
		
		int fee=Integer.parseInt(cfee.trim());
		int duration=Integer.parseInt(cduration.trim());
		int capacity=Integer.parseInt(ccapacity.trim());
		
		int avail=capacity;
		
CourseBean course=new CourseBean(cname, fee, duration, capacity, avail);
		
CourseDao dao=CourseDaoFactory.getCourseDao();

  boolean flag=dao.addNewCourse(course);

  if(flag){
	  response.sendRedirect("courseSucess.jsp");
  }
  else
	  response.sendRedirect("courseFails.jsp");
  
  


		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
