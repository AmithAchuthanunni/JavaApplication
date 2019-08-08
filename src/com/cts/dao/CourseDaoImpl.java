package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.beans.CourseBean;
import com.cts.utility.DBUtil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public boolean addNewCourse(CourseBean course) {
		
		boolean flag=false;
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("insert into course values(?,?,?,?,?)");
			
			ps.setString(1, course.getName());
			ps.setInt(2, course.getFee());
			ps.setInt(3, course.getDuration());
			ps.setInt(4, course.getCapacity());
			ps.setInt(5, course.getAvail());
			
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
	public List<CourseBean> getAllCourses() {
	
		List<CourseBean> courses=new ArrayList<CourseBean>();
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from course");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				String name=rs.getString(1);
				int fee=rs.getInt(2);
				int duration=rs.getInt(3);
				int capacity=rs.getInt(4);
				int avail=rs.getInt(5);
				
				CourseBean course=new CourseBean(name, fee, duration, capacity, avail);
				
				courses.add(course);
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return courses;
		
	}

	@Override
	public CourseBean getCourseDetails(String cname) {
		
		CourseBean course=null;
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from course where name=?");
			
			ps.setString(1, cname);
			
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next()){
				
			course=new CourseBean(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));	
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return course;
		
	}

	@Override
	public int getCapacity(String cname) {
		int cap=0;
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select capacity from course where name=?");
			
			ps.setString(1, cname);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				cap=rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return cap;
	}

	@Override
	public int getAvailibility(String cname) {
		int av=0;
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select avail from course where name=?");
			
			ps.setString(1, cname);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				av=rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return av;
	}

	@Override
	public boolean updateCourse(CourseBean course) {
		
		boolean flag=false;
		
		Connection conn=DBUtil.getDBConnection();
		
		
		try {
			PreparedStatement ps=conn.prepareStatement("update course set fee=?,duration=?,capacity=?,avail=? where name=?");
			
			ps.setInt(1, course.getFee());
			ps.setInt(2, course.getDuration());
			ps.setInt(3, course.getCapacity());
			ps.setInt(4, course.getAvail());
			ps.setString(5, course.getName());
			
			int x=ps.executeUpdate();
			
			if(x>0)
				flag=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return flag;
	}

	
	
	
	
	
}
