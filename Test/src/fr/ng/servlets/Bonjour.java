package fr.ng.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ng.beans.Auteur;

@WebServlet("/Test")
public class Bonjour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Bonjour() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String name = request.getParameter("nom");
		request.setAttribute("name", name);
		
		String[] names = {"Matthieu", "François", "Isabelle"};
		request.setAttribute("names", names);
		
		String message = "Au revoir!";
		request.setAttribute("myvar", message);
		
		request.setAttribute("heure", "jour");
		
		Auteur auteur = new Auteur();
		auteur.setNom("Toto");
		auteur.setPrenom("Côme");
		auteur.setActif(true);
		
		request.setAttribute("auteur", auteur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
