package com.admin.servlet;

import java.io.IOException;

import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			if("admin@gmail.com".equals(email)&& "admin".equals(password)) {
				
				session.setAttribute("adminObj", new User());
				
				resp.sendRedirect("admin/index.jsp");
			}
			else {
				
session.setAttribute("errorMsg", "invalid email & password");
				
				resp.sendRedirect("admin.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
