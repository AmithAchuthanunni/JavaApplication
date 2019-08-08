package com.cts.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.beans.StudentBean;
import com.cts.dao.StudentDao;
import com.cts.dao.StudentDaoFactory;

/**
 * Servlet implementation class EnrollSrv
 */
@WebServlet("/EnrollSrv")
public class EnrollSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cname=request.getParameter("cname");
		
		HttpSession ses=request.getSession();
		
		StudentBean student=(StudentBean)ses.getAttribute("studentdata");
		
		int roll=student.getRoll();
		
		
		StudentDao dao=StudentDaoFactory.getStudentDao();
		
		boolean flag=dao.enroll(roll, cname);
		
		if(flag)
			response.sendRedirect("enrollSucess.jsp");
		else
			response.sendRedirect("enrollFails.jsp");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
