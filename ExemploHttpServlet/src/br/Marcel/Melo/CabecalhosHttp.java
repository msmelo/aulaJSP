package br.Marcel.Melo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CabecalhosHttp
 */
@WebServlet("/CabecalhosHttp")
public class CabecalhosHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Enumeration headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header = (String) headers.nextElement();
			out.println(header+":"+ request.getHeader(header)+"<br>");
		}
		
	}

}
