package fr.ng.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {

	private String resultat;

	public void checkIdentifiant(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("password");

		if (pass.equals(login + "123")) {
			resultat = "Vous êtes bien connecté!";
		} else {
			resultat = "Indentifiants incorrects !";
		}
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}
