package fr.ng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.ng.beans.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private DaoFactory daoFactory;

	public UtilisateurDAOImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) {
		Connection connection;

		try {
			connection = daoFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Utilisateur> lister() {
		List<Utilisateur> utilisateurs = new ArrayList<>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");

			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");

				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);

				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateurs;
	}

}
