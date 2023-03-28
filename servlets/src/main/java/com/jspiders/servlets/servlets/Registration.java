package com.jspiders.servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Registration extends HttpServlet {

	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response)
						throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		writer.println("Hello " + name);
		String[] skills = request.getParameterValues("skills");
		writer.println("Your skills are :");
		for (String skill : skills) {
			writer.println(skill);
		}
	}

}
