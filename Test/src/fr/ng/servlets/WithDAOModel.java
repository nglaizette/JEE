package fr.ng.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ng.beans.Utilisateur;
import fr.ng.dao.DaoFactory;
import fr.ng.dao.UtilisateurDAO;

@WebServlet("/WithDAOModel")
public class WithDAOModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WithDAOModel() {
		super();
	}

	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao = daoFactory.getUtilisateurDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setAttribute("utilisateurs", utilisateurDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/withdaomodel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));

		utilisateurDao.ajouter(utilisateur);

		request.setAttribute("utilisateurs", utilisateurDao.lister());
		doGet(request, response);
	}

}
