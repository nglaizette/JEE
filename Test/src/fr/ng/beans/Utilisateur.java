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

	/**
	 * On limite arbitrairement le nom à 10 caractères
	 *
	 * @param nom
	 */
	public void setNom(String nom) throws BeanException {
		if (nom.length() > 10) {
			throw new BeanException("Le nom est trop grand! (10 caractères maximum)");
		}

		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
