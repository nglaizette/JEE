package fr.ng.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ng.forms.ConnectionForm;

@WebServlet("/Formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Formulaire() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		
		request.setAttribute("nom", nom);
		
		ConnectionForm form = new ConnectionForm();
		form.checkIdentifiant(request);
		request.setAttribute("form", form);
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
		//doGet(request, response);
	}

}
