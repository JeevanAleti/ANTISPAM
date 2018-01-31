package com.ibm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/antispam","jeevan reddy","jeevan5005");
			PreparedStatement pstmt=con.prepareStatement("insert into mrec.register values(?,?,?,?,?,?,?)");
			String s1=request.getParameter("name");
			String s2=request.getParameter("id");
			String s3=request.getParameter("pass");
			String s4=request.getParameter("dob");
			String s5=request.getParameter("emailid");
			String s6=request.getParameter("mobile");
			String s7=request.getParameter("city");
			
			System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7);
			
			pstmt.setString(1, s1);  
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			pstmt.setString(4, s4);
			pstmt.setString(5, s5);
			pstmt.setString(6, s6);
			pstmt.setString(7, s7);
			pstmt.executeUpdate();
			
			 response.sendRedirect("clicktologin.jsp");
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		
	}
		
	}


