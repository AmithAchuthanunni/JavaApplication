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
 * Servlet implementation class LoginSrv
 */
@WebServlet("/LoginSrv")
public class LoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String loginas=request.getParameter("loginas");
		
		String page="loginfails.jsp";
		
		if(loginas.equals("Admin")){
			
			if(uname.equals("Admin") && pass.equals("Admin"))
				page="adminHome.jsp";
		}
		
		
		if(loginas.equals("Student")){
			
		StudentDao dao=StudentDaoFactory.getStudentDao();
		
		StudentBean sbean=dao.validateStudent(uname, pass);
			
		if(sbean != null){
			
			HttpSession ses=request.getSession();
			
			ses.setAttribute("studentdata", sbean);
			page="studentHome.jsp";
			
			
		}
		
			
		}
		
	
	request.getRequestDispatcher(page).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
