
package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/first")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Read the form data
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				// Set the Attribute
				request.setAttribute("use", username);
				request.setAttribute("pas", password);
				//  request to the servlet2
				if(username.equals("Divya") && password.equals("1234")) {
		            // valid : forward to WelcomeServlet
		            RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
		            rd.forward(request, response);
		        } else {
		            // invalid : include error.html
		            RequestDispatcher rd = request.getRequestDispatcher("Error.html");
		            rd.include(request, response);
		        }
}
}
