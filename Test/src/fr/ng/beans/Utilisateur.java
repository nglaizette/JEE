package fr.ng.beans;

/**
 * Classe qui stocke le nom et prénom de l'utilisateur.
 * 
 * @author NG
 *
 */
public class Utilisateur {

	private String nom;
	private String prenom;

	public Utilisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
