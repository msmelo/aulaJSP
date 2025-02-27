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
 * Servlet implementation class EditarUsuarioServlet
 */
@WebServlet("/EditarUsuario")
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		User usuario = userDao.getUser(id);
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("/editarUsuario.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User usuario = new User();
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setName(request.getParameter("name"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setEmail(request.getParameter("email"));
		
		UserDAO userDao = new UserDAO();
		userDao.updateUser(usuario);
		
		request.setAttribute("usuarios", userDao.getAllUsers());
		request.getRequestDispatcher("/indexCrud.jsp").forward(request, response);
	}

}
