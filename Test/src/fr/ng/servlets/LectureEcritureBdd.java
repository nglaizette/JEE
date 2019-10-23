package fr.ng.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ng.bdd.MyNoms;
import fr.ng.beans.Utilisateur;

/**
 * Servlet implementation class LectureEcritureBdd
 */
@WebServlet("/LectureEcritureBdd")
public class LectureEcritureBdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LectureEcritureBdd() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyNoms tableNoms = new MyNoms();
		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/lectureecriturebdd.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));

		MyNoms tableNoms = new MyNoms();
		tableNoms.ajouterUtilisateur(utilisateur);

		doGet(request, response);
	}

}
