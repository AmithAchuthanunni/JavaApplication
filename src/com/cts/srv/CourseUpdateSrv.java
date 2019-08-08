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
import com.cts.dao.StudentDaoFactory;

/**
 * Servlet implementation class CourseUpdateSrv
 */
@WebServlet("/CourseUpdateSrv")
public class CourseUpdateSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseUpdateSrv() {
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
		String cavail=request.getParameter("cavail");
		
		
		int fee=Integer.parseInt(cfee.trim());
		int duration=Integer.parseInt(cduration.trim());
		int capacity=Integer.parseInt(ccapacity.trim());
		int avail=Integer.parseInt(cavail.trim());
		
		
		CourseDao dao=CourseDaoFactory.getCourseDao();
		
		int booked=dao.getCapacity(cname)-dao.getAvailibility(cname);
		
		if(capacity<booked){
			response.sendRedirect("cupdate.jsp?flag="+booked);
			
		}
		else{
			
			int newAv=capacity-booked;
			
			CourseBean course=new CourseBean(cname, fee, duration, capacity, newAv);
			
			
			boolean f=dao.updateCourse(course);
			
			if(f)
				response.sendRedirect("cupdateSucess.jsp");
			else
				response.sendRedirect("cupdateFails.jsp");
			
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
