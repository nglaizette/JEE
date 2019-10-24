package fr.ng.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie
 */
@WebServlet("/Cookie")
public class MyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyCookie() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupération des cookies
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cookieprenom")) {
					request.setAttribute("prenom", cookie.getValue());
				}
			}
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/cookie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("cookienom");
		String prenom = request.getParameter("cookieprenom");

		Cookie cookie = new Cookie("cookieprenom", prenom);
		cookie.setMaxAge(60 * 60 * 24 * 30); // durée du stockage. nb de secondes expiration cookie
		response.addCookie(cookie);
		this.getServletContext().getRequestDispatcher("/WEB-INF/cookie.jsp").forward(request, response);
	}

}
