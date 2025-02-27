package br.marcel.melo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.marcel.melo.crud.User;
import br.marcel.melo.crud.UserDAO;

/**
 * Servlet implementation class NovoUsuarioServlet
 */
@WebServlet("/NovoUsuario")
public class NovoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NovoUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/novoUsuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User usuario = new User();
		usuario.setName(request.getParameter("name"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setEmail(request.getParameter("email"));
		
		UserDAO userDao = new UserDAO();
		userDao.saveUser(usuario);
		
		request.setAttribute("usuarios", userDao.getAllUsers());
		request.getRequestDispatcher("/indexCrud.jsp").forward(request, response);
	}

}
