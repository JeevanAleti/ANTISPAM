package com.ibm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.connection.Connect2Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1st Approach
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");  
		 //2nd Approach
		 //3rd Approach
		 //Difference between null and ""
		HttpSession session=request.getSession();
		 if(id.equals("")||id==null||pass.equals("")||pass==null)
		 {
			 response.getWriter().write("Fill all the details");
			 
		 }
		 else if(Connect2Dao.isValid(id, pass))
		 {
			 session.setAttribute("id", id);
			 response.sendRedirect("Comment.jsp");
			 
		 }
		 
		 else 
		 {
			 response.sendRedirect("Error.html");

		 }
	}

}
