package br.marcel.melo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.marcel.melo.crud.UserDAO;

/**
 * Servlet implementation class ListarUsuariosServlet
 */
@WebServlet("/ListarUsuarios")
public class ListarUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarUsuariosServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		request.setAttribute("usuarios", userDao.getAllUsers());
		request.getRequestDispatcher("/indexCrud.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
