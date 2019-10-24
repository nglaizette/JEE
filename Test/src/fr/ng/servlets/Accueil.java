package fr.ng.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ng.beans.Auteur;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Accueil() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Auteur auteur = new Auteur();
		auteur.setNom("Totolito");
		auteur.setPrenom("Côme quat");
		auteur.setActif(true);

		request.setAttribute("auteur", auteur);

		String[] titres = { "Nouvel incendie", "Une île a été découverte", "Chute du dollar" };
		request.setAttribute("titres", titres);
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
