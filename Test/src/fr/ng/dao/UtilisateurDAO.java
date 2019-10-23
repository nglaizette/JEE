package fr.ng.dao;

import java.util.List;

import fr.ng.beans.Utilisateur;

public interface UtilisateurDAO {
	void ajouter(Utilisateur utilisateur);

	List<Utilisateur> lister();
}
