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
 * Servlet implementation class UpdateStudentSrv
 */
@WebServlet("/UpdateStudentSrv")
public class UpdateStudentSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sroll=request.getParameter("sroll");
		String sname=request.getParameter("sname");
		String saddress=request.getParameter("saddress");
		String semail=request.getParameter("semail");
		String sphone=request.getParameter("sphone");
		String spassword=request.getParameter("spassword");
		
		int roll=Integer.parseInt(sroll.trim());
		
StudentBean student=new StudentBean(roll, sname, saddress, semail, sphone, spassword);		
		
		
	StudentDao dao=StudentDaoFactory.getStudentDao();

	boolean f=dao.updateStudent(student);

	if(f){
			
		HttpSession ses=request.getSession();
		ses.setAttribute("studentdata", student);
		
		
		response.sendRedirect("updatesucess.jsp");
		
	}
	else
		response.sendRedirect("updatefails.jsp");
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
