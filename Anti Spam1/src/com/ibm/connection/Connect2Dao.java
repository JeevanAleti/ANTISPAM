package com.ibm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connect2Dao {
	
	
	
	private static Connection con=null;
	private static String url="jdbc:db2://localhost:50000/ANTISPAM",user="Jeevan Reddy",password="jeevan5005";
	static{
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			con=DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static Connection getCon(){
		return con;
	}
	
	public static boolean isValid(String user_id,String password){
		String sql="select * from mrec.register where id=? and pass=?";
		try{
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, user_id);
			psmt.setString(2, password);
			ResultSet rs=psmt.executeQuery();
			return (rs.next());
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
		
	}
	
	

}
