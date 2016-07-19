package br.marcel.melo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginOKReescritaServlet
 */
@WebServlet("/LoginOKReescritaURL")
public class LoginOKReescritaURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		if(nome == null || senha == null){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Login Required</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Faça o Login primeiro, mermão</h1>");
			out.println("<a href=LoginReescritaURL><h2>Login Aqui</h2></a>" );
			out.println("</body>");
			out.println("</html>");
			
		}else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Login OK - Reescrita URL</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Login Deu tudo bão</h1>");
			out.println("<h2> User - "+nome+"</h1>");
			out.println("<h2> PASS - "+senha+"</h1> <br><br>");
			out.println("<a href=Servlet3?nome="+nome+"&senha="+senha+">Servlet 3 - OK</a>" );
			out.println("<a href=Servlet3>Servlet 3 -NOK</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
