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
import com.cts.utility.GenRoll;

/**
 * Servlet implementation class StudentRegisterSrv
 */
@WebServlet("/StudentRegisterSrv")
public class StudentRegisterSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("sname");
		String address=request.getParameter("saddres");
		String email=request.getParameter("semail");
		String phone=request.getParameter("sphone");
		String password=request.getParameter("spassword");
		
		int roll=GenRoll.generateRoll();
		
StudentBean student=new StudentBean(roll, name, address, email, phone, password);	
		
StudentDao dao=StudentDaoFactory.getStudentDao();

	int roll1=dao.registerStudent(student);
		
	if(roll1>0){
		
		HttpSession ses=request.getSession();			
		ses.setAttribute("resultdata", roll1);
	
		response.sendRedirect("sucess.jsp");
		
	}else
	{
		response.sendRedirect("fails.jsp");
		
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
