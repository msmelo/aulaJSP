package br.marcel.melo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.marcel.melo.crud.User;
import br.marcel.melo.crud.UserDAO;

@WebServlet("/RemoverUsuario")
public class RemoverUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoverUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		
		request.setAttribute("usuarios", userDao.getAllUsers());
		request.getRequestDispatcher("/indexCrud.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		request.setAttribute("usuarios", userDao.getAllUsers());
		request.getRequestDispatcher("/indexCrud.jsp").forward(request, response);
	}

}
