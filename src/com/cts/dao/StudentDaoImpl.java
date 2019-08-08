package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.beans.CourseBean;
import com.cts.beans.StudentBean;
import com.cts.utility.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public int registerStudent(StudentBean student) {
		
		int roll=0;
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
			
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPhone());
			ps.setString(6, student.getPassword());
			
			int x=ps.executeUpdate();
			
			if(x>0)
				roll=student.getRoll();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return roll;
	}

	@Override
	public StudentBean validateStudent(String username, String password) {
		
		StudentBean student=null;
		
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from student where email=? AND password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				
				
				student=new StudentBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6));				
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return student;
		
	}

	@Override
	public boolean updateStudent(StudentBean student) {
		
		boolean flag=false;
		
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("update student set name=?,address=?,email=?,phone=?,password=? where roll=?");
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPhone());
			ps.setString(5, student.getPassword());
			ps.setInt(6, student.getRoll());
			
			int x=ps.executeUpdate();
			
			if(x>0)
				flag=true;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
		
	}

	@Override
	public boolean enroll(int roll, String cname) {
		
		boolean flag=false;
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("insert into student_course values(?,?)");
			
			ps.setInt(1, roll);
			ps.setString(2, cname);
			
			int x=ps.executeUpdate();
			
			
			if(x>0){
				
				ps=conn.prepareStatement("update course set avail=avail-1 where name=?");
				ps.setString(1, cname);
				
				int y=ps.executeUpdate();
				
				if(y>0)
					flag=true;
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}

	@Override
	public List<CourseBean> getEnrolledCourses(int roll) {
		
		List<CourseBean> courses=new ArrayList<CourseBean>();
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select c.name,c.fee,c.duration from course c,student s,student_course sc where c.name=sc.cname AND s.roll=sc.roll AND s.roll=?");
			
			ps.setInt(1, roll);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				String name=rs.getString(1);
				int fee=rs.getInt(2);
				int duration=rs.getInt(3);
				
				CourseBean course=new CourseBean(name, fee, duration, 0,0);
				
				courses.add(course);
				
				
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return courses;
		
	}

}
