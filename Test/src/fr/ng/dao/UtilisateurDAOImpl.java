package fr.ng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.ng.beans.BeanException;
import fr.ng.beans.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private DaoFactory daoFactory;

	public UtilisateurDAOImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) throws DaoException {
		Connection connection = null;

		try {
			connection = daoFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());

			ps.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e2) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}

		}

	}

	@Override
	public List<Utilisateur> lister() throws DaoException {
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
			throw new DaoException("Impossible de communiquer avec la base de données");
		} catch (BeanException e) {
			throw new DaoException("Les données de la base sont invalides");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de donnée");
			}
		}
		return utilisateurs;
	}

}
