package com;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet implements Servlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pass =  request.getParameter ("pass");
		PrintWriter out = response.getWriter();
		out.print("in first servlet");

		if ((uname.equals("akash")) && (pass.equals("singh"))) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);

			response.sendRedirect("Welcome.jsp");
			/*RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);*/

		} else {

			response.sendRedirect("Index.jsp");
		}

	}

	// step5 close the connection object
	// con.close();

	// }catch(Exception e)
	// { System.out.println(e);}

}
