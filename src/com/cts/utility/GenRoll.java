package com.cts.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenRoll {
	
	
	public static int generateRoll(){
		
		int roll=1000;
		
		
		Connection conn=DBUtil.getDBConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select max(roll) from student");
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				int i=rs.getInt(1);
				
				if(i>0)
					roll=i+1;
			
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		return roll;
	}

}
